package org.gbif.doi.services;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.DoiException;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;

import java.io.StringWriter;
import java.net.URI;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.net.MediaType;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides common methods to be used by all services.
 */
public abstract class BaseService {

  private static final Logger LOG = LoggerFactory.getLogger(BaseService.class);
  private final HttpClient httpClient;
  protected final UsernamePasswordCredentials credentials;
  private final JAXBContext context;
  protected BaseService(HttpClient httpClient, String username, String password) {
    this.httpClient = httpClient;
    this.credentials = new UsernamePasswordCredentials(username, password);
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
  protected void post(URI uri, DataCiteMetadata data) throws DoiException {
    LOG.info("POST: {}", uri);
    call(uri, data, new HttpPost(uri));
  }

  /**
   * Executes an HTTP PUT request.
   *
   * @param uri  to issue request against
   * @param data request body content to be serialized as XML with jackson
   *
   * @throws org.gbif.doi.DoiException in case anything goes wrong during the request.
   */
  protected void put(URI uri, DataCiteMetadata data) throws DoiException {
    LOG.info("PUT: {}", uri);
    call(uri, data, new HttpPut(uri));
  }

  protected void delete(URI uri) throws DoiException {
    LOG.info("DELETE: {}", uri);
    try {
      HttpContext authContext = buildAuthContext(uri, credentials);
      HttpDelete del = new HttpDelete(uri);
      HttpResponse response = httpClient.execute(del, authContext);
    } catch (Throwable e) {
      throw new DoiException(e);
    }
  }

  @VisibleForTesting
  protected String toXml(DataCiteMetadata data) throws JAXBException {
    // (un)marshaller are not thread safe and need to be created on each call
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    StringWriter writer = new StringWriter();
    m.marshal(data, writer);
    writer.flush();
    return writer.toString();
  }

  private void call(URI uri, DataCiteMetadata data, HttpEntityEnclosingRequestBase req) throws DoiException {
    try {
      req.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_XML_UTF_8.toString());
      // body
      if (data != null) {
        HttpEntity entity = new ByteArrayEntity(toXml(data).getBytes(Charsets.UTF_8));
        req.setEntity(entity);
      }

      // authentication
      HttpContext authContext = buildAuthContext(uri, credentials);
      HttpResponse response = httpClient.execute(req, authContext);

      // Everything but HTTP status 201 is an error
      if (response.getStatusLine().getStatusCode() != 201) {
        LOG.debug("Received HTTP code[{}] cause[{}] for request: {}", response.getStatusLine().getStatusCode(),
          response.getStatusLine().getReasonPhrase(), uri);
        String cause = String.format("Received HTTP code[%d], phrase[%s]", response.getStatusLine().getStatusCode(),
          response.getStatusLine().getReasonPhrase());
        throw new DoiException(cause);
      }

    } catch (DoiException e) {
      throw e;
    } catch (Throwable e) {
      throw new DoiException(e);
    }
  }

  private HttpContext buildAuthContext(URI uri, UsernamePasswordCredentials credentials) {
    HttpContext authContext = new BasicHttpContext();
    if (credentials != null) {
      AuthScope scope = new AuthScope(uri.getHost(), AuthScope.ANY_PORT, AuthScope.ANY_REALM);

      CredentialsProvider credsProvider = new BasicCredentialsProvider();
      credsProvider.setCredentials(scope, credentials);

      authContext.setAttribute(ClientContext.CREDS_PROVIDER, credsProvider);
    }

    return authContext;
  }

  protected void updateMetadataIdentifier(DOI doi, DataCiteMetadata metadata) {
    metadata.setIdentifier(
      DataCiteMetadata.Identifier.builder().withValue(doi.toString()).withIdentifierType("DOI").build()
    );
  }

  /**
   * @return a random DOI with the given prefix. It is not guaranteed to be unique and might exist already
   */
  protected DOI random(String prefix) {
    String suffix = RandomStringUtils.randomAlphanumeric(8);
    DOI doi = new DOI(prefix, suffix);
    return doi;
  }
}
