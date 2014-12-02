package org.gbif.doi.services;

import org.gbif.doi.DoiRegistrarException;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.common.base.Charsets;
import com.google.common.net.MediaType;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
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
  private final UsernamePasswordCredentials credentials;
  private final Marshaller serilizer;

  protected BaseService(HttpClient httpClient, String username, String password) {
    this.httpClient = httpClient;
    this.credentials = new UsernamePasswordCredentials(username, password);
    try {
      JAXBContext context = JAXBContext.newInstance(BaseService.class);
      serilizer = context.createMarshaller();
      serilizer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    } catch (JAXBException e) {
      throw new IllegalStateException("Fail to setup JAXB", e);
    }
  }

  /**
   * Executes an HTTP POST request.
   *
   * @param uri  to issue request against
   * @param data request body content to be serialized as XML with jackson
   */
  public void postXml(URI uri, Object data) throws DoiRegistrarException {
    LOG.info("Issuing POST request: {}", uri);
    HttpPost post = new HttpPost(uri);

    // http content type header

    post.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_XML_UTF_8.toString());

    // body
    if (data != null) {
      try {
        StringWriter writer = new StringWriter();
        serilizer.marshal(data, writer);
        writer.close();
        HttpEntity entity = new ByteArrayEntity(writer.toString().getBytes(Charsets.UTF_8));
        post.setEntity(entity);
      } catch (Exception e) {
        throw new DoiRegistrarException(e);
      }
    }

    // authentication
    HttpResponse response;
    try {
      HttpContext authContext = buildContext(uri, credentials);
      response = httpClient.execute(post, authContext);
    } catch (Throwable e) {
      throw new DoiRegistrarException(e);
    }

    // Everything but HTTP status 201 is an error
    if (response.getStatusLine().getStatusCode() != 201) {
      LOG.debug("Received HTTP code[{}] cause[{}] for request: {}", response.getStatusLine().getStatusCode(),
        response.getStatusLine().getReasonPhrase(), uri);
      String cause = String.format("Received HTTP code[%d], phrase[%s]", response.getStatusLine().getStatusCode(),
        response.getStatusLine().getReasonPhrase());
      throw new DoiRegistrarException(cause);
    }
  }

  private HttpContext buildContext(URI uri, UsernamePasswordCredentials credentials) {
    HttpContext authContext = new BasicHttpContext();
    if (credentials != null) {
      AuthScope scope = new AuthScope(uri.getHost(), AuthScope.ANY_PORT, AuthScope.ANY_REALM);

      CredentialsProvider credsProvider = new BasicCredentialsProvider();
      credsProvider.setCredentials(scope, credentials);

      authContext.setAttribute(ClientContext.CREDS_PROVIDER, credsProvider);
    }

    return authContext;
  }
}
