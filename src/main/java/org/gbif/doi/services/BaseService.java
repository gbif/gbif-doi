package org.gbif.doi.services;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.DoiException;
import org.gbif.doi.DoiHttpException;
import org.gbif.doi.InvalidMetadataException;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.services.datacite.DataciteValidator;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
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
public abstract class BaseService {

  private static final Logger LOG = LoggerFactory.getLogger(BaseService.class);
  private static final ContentType APPLICATION_XML_UTF8 = ContentType.create("application/xml", Charsets.UTF_8);
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
   * Executes an HTTP POST request.
   *
   * @param uri  to issue request against
   * @param data request body content to be serialized as XML with jackson
   *
   * @throws org.gbif.doi.DoiException in case anything goes wrong during the request.
   */
  protected void post(DOI doi, URI uri, DataCiteMetadata data) throws DoiException {
    LOG.debug("POST: {}", uri);
    postOrPut(doi, data, new HttpPost(uri));
  }

  /**
   * Executes an HTTP PUT request.
   *
   * @param uri  to issue request against
   * @param data request body content to be serialized as XML with jackson
   *
   * @throws org.gbif.doi.DoiException in case anything goes wrong during the request.
   */
  protected void put(DOI doi, URI uri, DataCiteMetadata data) throws DoiException {
    LOG.debug("PUT: {}", uri);
    postOrPut(doi, data, new HttpPut(uri));
  }

  protected void delete(URI uri) throws DoiException {
    LOG.debug("DELETE: {}", uri);
    try {
      HttpDelete del = new HttpDelete(uri);
      CloseableHttpResponse resp = httpClient.execute(del, buildAuthContext());
      resp.close();
    } catch (Throwable e) {
      throw new DoiException(e);
    }
  }

  @VisibleForTesting
  protected String toXml(DataCiteMetadata data) throws JAXBException {
    // (un)marshaller are not thread safe and need to be created on each authCall
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, DATACITE_SCHEMA_LOCATION);

    StringWriter writer = new StringWriter();
    m.marshal(data, writer);
    writer.flush();
    return writer.toString();
  }

  protected void postOrPut(DOI doi, DataCiteMetadata data, HttpEntityEnclosingRequestBase req) throws DoiException {
    // body
    if (data != null) {
      try {
        String xml = toXml(data);
        // validate the xml before we send it to datacite
        try {
          DataciteValidator.validateMetadata(xml);
          LOG.debug("Metadata XML passed validation for ID: {}", doi);
        } catch (SAXException e) {
          throw new InvalidMetadataException(doi, e);
        }
        HttpEntity entity = new StringEntity(xml, APPLICATION_XML_UTF8);
        req.setEntity(entity);
        authCall(req);

      } catch (Exception e) {
        throw new DoiException(e);
      }
    }
  }

  protected void authCall(HttpUriRequest req) throws DoiException {
    CloseableHttpResponse resp = authCallWithResponse(req);
    closeSilently(resp);
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
   * Does an authenticated call and throws a DoiHttpException for nun successful responses other than 2xx.
   * This returns an open http connection, make sure to close the response!!!
   * @throws DoiException
   */
  private CloseableHttpResponse authCallWithResponse(HttpUriRequest req) throws DoiException {
    CloseableHttpResponse resp = null;
    try {
      // authentication
      resp = httpClient.execute(req, buildAuthContext());
      // Everything but HTTP 2xx is an error
      if (Math.round( resp.getStatusLine().getStatusCode() / 100.0) != 2) {
        LOG.debug("Received HTTP {}: {}", resp.getStatusLine().getStatusCode(), resp.getStatusLine().getReasonPhrase());
        closeSilently(resp);
        throw new DoiHttpException(resp.getStatusLine().getStatusCode());
      }
      return resp;

    } catch (DoiException e) {
      throw e;
    } catch (Throwable e) {
      throw new DoiException(e);
    }
  }

  /**
   * Does an http GET and returns the full body entity as a String
   */
  protected String get(URI uri) throws DoiException {
    CloseableHttpResponse resp = authCallWithResponse(new HttpGet(uri));
    try {
      String content = EntityUtils.toString(resp.getEntity(), Charsets.UTF_8);
      return content;
    } catch (IOException e) {
      throw new DoiException(e);
    } finally {
      closeSilently(resp);
    }
  }

  private HttpContext buildAuthContext() {
    HttpContext authContext = new BasicHttpContext();
    authContext.setAttribute(ClientContext.CREDS_PROVIDER, credsProvider);
    return authContext;
  }

  protected static void updateMetadataIdentifier(DOI doi, DataCiteMetadata metadata) {
    metadata.setIdentifier(
      DataCiteMetadata.Identifier.builder().withValue(doi.getDoiName()).withIdentifierType("DOI").build());
  }

  /**
   * @return a random DOI with the given prefix. It is not guaranteed to be unique and might exist already
   */
  protected static DOI random(String prefix, int length) {
    String suffix = RandomStringUtils.randomAlphanumeric(length);
    DOI doi = new DOI(prefix, suffix);
    return doi;
  }

  protected static URI doiUri(URI base, DOI doi) {
    return URI.create(base.toString()+"/"+doi.getDoiName());
  }

}
