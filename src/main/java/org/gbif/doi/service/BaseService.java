package org.gbif.doi.service;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.datacite.DataCiteValidator;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * This class provides common methods to be used by all services.
 */
public abstract class BaseService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(BaseService.class);
  protected static final ContentType PLAIN_TEXT_UTF8 = ContentType.create("text/plain", Charsets.UTF_8);
  private static final String DATACITE_SCHEMA_LOCATION = "http://datacite.org/schema/kernel-3 http://schema.datacite.org/meta/kernel-3/metadata.xsd";

  private final CloseableHttpClient httpClient;
  private final CredentialsProvider credsProvider;
  private final JAXBContext context;

  protected BaseService(CloseableHttpClient httpClient, ServiceConfig cfg) {
    this.httpClient = httpClient;
    LOG.info("Setup DOI service using account {}", cfg.getUsername());
    credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(cfg.getUsername(), cfg.getPassword()));
    try {
      context = JAXBContext.newInstance(DataCiteMetadata.class);
    } catch (JAXBException e) {
      throw new IllegalStateException("Fail to setup JAXB", e);
    }
  }

  /**
   * Produces a validated xml representation of the data cite metadata.
   * The DOI inside the metadata is overwritten to always represent the given DOI
   * and the generated XML is validated according to the datacite xsd schema.
   * @return xml string
   * @throws InvalidMetadataException, DoiException
   */
  @VisibleForTesting
  protected String toXml(DOI doi, DataCiteMetadata data) throws InvalidMetadataException {
    // make sure we use the right doi inside the metadata
    data.setIdentifier(DataCiteMetadata.Identifier.builder()
        .withValue(doi.getDoiName())
        .withIdentifierType("DOI")
        .build()
    );
    // (un)marshaller are not thread safe and need to be created on each authCall
    StringWriter writer = new StringWriter();
    try {
      Marshaller m = context.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, DATACITE_SCHEMA_LOCATION);

      m.marshal(data, writer);
      writer.flush();
    } catch (JAXBException e) {
      throw new InvalidMetadataException(doi, e);
    }

    final String xml = writer.toString();
    // validate the xml before we send it to datacite
    try {
      DataCiteValidator.validateMetadata(xml);
      LOG.debug("Metadata XML passed validation", doi);

    } catch (SAXException e) {
      throw new InvalidMetadataException(doi, e);

    } catch (IOException e) {
      // cant happen, we had a string in memory already!
      throw new IllegalStateException(e);
    }
    return xml;
  }

  /**
   * Does an authenticated call and throws a DoiHttpException for nun successful responses other than 2xx.
   * If successful return the entities body as a string.
   * @throws DoiException
   */
  protected String authCall(HttpUriRequest req) throws DoiException {
    CloseableHttpResponse resp = null;
    try {
      // authentication
      resp = httpClient.execute(req, buildAuthContext());
      // Everything but HTTP 2xx is an error
      if (!isSuccess(resp)) {
        // read response body and use as error message
        String msg = EntityUtils.toString(resp.getEntity(), Charsets.UTF_8);
        LOG.debug("Received HTTP {} {}: {}", resp.getStatusLine().getStatusCode(), resp.getStatusLine().getReasonPhrase(), msg);
        closeSilently(resp);
        throw new DoiHttpException(resp.getStatusLine().getStatusCode(), msg);
      }
      return EntityUtils.toString(resp.getEntity(), Charsets.UTF_8);

    } catch (DoiException e) {
      throw e;
    } catch (Throwable e) {
      throw new DoiException(e);
    } finally {
      closeSilently(resp);
    }
  }

  private static void closeSilently(CloseableHttpResponse resp) {
    if (resp != null) {
      try {
        resp.close();
      } catch (IOException e) {
        LOG.warn("Could not close http connection", e);
        // ignore, we're done the request was executed
      }
    }
  }

  /**
   * Does an authenticated http GET and returns the full body entity as a String
   */
  protected String get(URI uri) throws DoiException {
    return authCall(new HttpGet(uri));
  }

  /**
   * Does an authenticated http DELETE and returns the full body entity as a String
   */
  protected String delete(URI uri) throws DoiException {
    return authCall(new HttpDelete(uri));
  }

  protected static boolean isSuccess(HttpResponse resp) {
    if (Math.round( resp.getStatusLine().getStatusCode() / 100.0) == 2) {
      return true;
    }
    return false;
  }

  @Override
  public DOI reserveRandom(String prefix, String shoulder, int length, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkArgument(length > 2, "The suffix length must be larger than 2");
    Preconditions.checkArgument(prefix.startsWith("10."), "The DOI prefix must begin with 10");

    // a random DOI might exist already so we need to try to reserve one until we find a good one.
    // to avoid endless loop do a max of 100 tries though, we should never ever reach that
    for (int x=1; x<100; x++) {
      DOI doi = random(prefix, shoulder, length);
      try {
        reserve(doi, metadata);
        return doi;
      } catch (DoiExistsException e) {
        LOG.debug("Randoom DOI existed. Try another one", e.getMessage());
      }
    }
    LOG.error("Failed to generate a new, random DOI for prefix {}. We have tried 100 random suffices.", prefix);
    throw new DoiException("Failed to generate a new, random DOI for prefix " + prefix);
  }


  private HttpContext buildAuthContext() {
    HttpContext authContext = new BasicHttpContext();
    authContext.setAttribute(HttpClientContext.CREDS_PROVIDER, credsProvider);
    return authContext;
  }

  /**
   * @return a random DOI with the given prefix. It is not guaranteed to be unique and might exist already
   */
  protected static DOI random(String prefix, String shoulder, int length) {
    String suffix = Strings.nullToEmpty(shoulder) + RandomStringUtils.randomAlphanumeric(length);
    DOI doi = new DOI(prefix, suffix);
    return doi;
  }

}
