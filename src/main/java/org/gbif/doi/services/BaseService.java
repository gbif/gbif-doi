package org.gbif.doi.services;

import org.gbif.api.vocabulary.Language;
import org.gbif.doi.DoiRegistrarException;
import org.gbif.doi.ErrorCode;
import org.gbif.doi.datacite.LanguageSerde;

import java.io.IOException;
import java.net.URI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.common.annotations.VisibleForTesting;
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
  @VisibleForTesting
  protected final static XmlMapper xmlMapper;
  static {
    JacksonXmlModule module = new JacksonXmlModule();
    module.setDefaultUseWrapper(true);
    module.addSerializer(Language.class, LanguageSerde.serializer);
    module.addDeserializer(Language.class, LanguageSerde.deserializer);
    xmlMapper = new XmlMapper(module);
    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    xmlMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    xmlMapper.configure( ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true );
  }

  private final HttpClient httpClient;
  protected final UsernamePasswordCredentials credentials;

  protected BaseService(HttpClient httpClient, String username, String password) {
    this.httpClient = httpClient;
    this.credentials = new UsernamePasswordCredentials(username, password);
  }

  /**
   * Executes an HTTP POST request.
   *
   * @param uri  to issue request against
   * @param data request body content to be serialized as XML with jackson
   *
   * @throws org.gbif.doi.DoiRegistrarException in case anything goes wrong during the request, all underlying HTTP errors are mapped to
   *                          the appropriate {@link ErrorCode}s.
   */
  public void postXml(URI uri, Object data) throws DoiRegistrarException {
    LOG.info("Issuing POST request: {}", uri);
    HttpPost post = new HttpPost(uri);

    // http content type header

    post.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_XML_UTF_8.toString());

    // body
    if (data != null) {
      try {
        HttpEntity entity = new ByteArrayEntity(xmlMapper.writeValueAsBytes(data));
        post.setEntity(entity);
      } catch (JsonProcessingException e) {
        throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
      }
    }

    // authentication
    HttpResponse response;
    try {
      HttpContext authContext = buildContext(uri, credentials);
      response = httpClient.execute(post, authContext);
    } catch (ClientProtocolException e) {
      throw new DoiRegistrarException(e, ErrorCode.HTTP_ERROR);
    } catch (IOException e) {
      throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
    } catch (Throwable e) {
      throw new DoiRegistrarException(e, ErrorCode.OTHER_ERROR);
    }

    // Everything but HTTP status 201 is an error
    if (response.getStatusLine().getStatusCode() != 201) {
      LOG.debug("Received HTTP code[{}] cause[{}] for request: {}", response.getStatusLine().getStatusCode(),
        response.getStatusLine().getReasonPhrase(), uri);
      String cause = String.format("Received HTTP code[%d], phrase[%s]", response.getStatusLine().getStatusCode(),
        response.getStatusLine().getReasonPhrase());
      throw new DoiRegistrarException(cause, ErrorCode.HTTP_ERROR);
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
