package org.gbif.doi.services;

import org.gbif.doi.api.ErrorCode;
import org.gbif.doi.api.DoiRegistrarException;
import org.gbif.utils.HttpUtil;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.protocol.BasicHttpContext;
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

  protected BaseService(HttpClient httpClient, String username, String password) {
    this.httpClient = httpClient;
    this.credentials = new UsernamePasswordCredentials(username, password);
  }

  /**
   * Executes an HTTP POST request.
   *
   * @param uri           to issue request against
   * @param headers       HTTP headers
   * @param encodedEntity request body
   *
   * @throws org.gbif.doi.api.DoiRegistrarException in case anything goes wrong during the request, all underlying HTTP errors are mapped to
   *                          the appropriate {@link ErrorCode}s.
   */
  public void doPost(URI uri, Map<String, String> headers, HttpEntity encodedEntity) throws DoiRegistrarException {
    LOG.info("Issuing POST request: {}", uri);
    HttpPost post = new HttpPost(uri);

    // http header
    if (headers != null) {
      for (Map.Entry<String, String> header : headers.entrySet()) {
        post.addHeader(StringUtils.trimToEmpty(header.getKey()), StringUtils.trimToEmpty(header.getValue()));
      }
    }

    // body
    if (encodedEntity != null) {
      post.setEntity(encodedEntity);
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

  /**
   * Executes an HTTP PUT request.
   *
   * @param uri           to issue request against
   * @param headers       HTTP headers
   * @param encodedEntity request body
   *
   * @throws org.gbif.doi.api.DoiRegistrarException in case anything goes wrong during the request, all underlying HTTP errors are mapped to
   *                          the appropriate {@link ErrorCode}s.
   */
  public void doPut(URI uri, Map<String, String> headers, HttpEntity encodedEntity)
    throws DoiRegistrarException {
    LOG.info("Issuing PUT request: {}", uri);
    HttpPut put = new HttpPut(uri);

    // http header
    if (headers != null) {
      for (Map.Entry<String, String> header : headers.entrySet()) {
        put.addHeader(StringUtils.trimToEmpty(header.getKey()), StringUtils.trimToEmpty(header.getValue()));
      }
    }

    // body
    if (encodedEntity != null) {
      put.setEntity(encodedEntity);
    }

    // authentication
    HttpResponse response;
    try {
      HttpContext authContext = buildContext(uri, credentials);
      response = httpClient.execute(put, authContext);
    } catch (ClientProtocolException e) {
      throw new DoiRegistrarException(e, ErrorCode.HTTP_ERROR);
    } catch (IOException e) {
      throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
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
