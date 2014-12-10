package org.gbif.doi.service;

import java.io.IOException;
import java.net.URI;

import com.google.common.base.Charsets;
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

/**
 * This class provides common methods to be used by all services.
 */
public abstract class BaseService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(BaseService.class);
  protected static final ContentType PLAIN_TEXT_UTF8 = ContentType.create("text/plain", Charsets.UTF_8);

  private final CloseableHttpClient httpClient;
  private final CredentialsProvider credsProvider;

  protected BaseService(CloseableHttpClient httpClient, ServiceConfig cfg) {
    this.httpClient = httpClient;
    LOG.info("Setup DOI service using account {}", cfg.getUsername());
    credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(cfg.getUsername(), cfg.getPassword()));
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

  private HttpContext buildAuthContext() {
    HttpContext authContext = new BasicHttpContext();
    authContext.setAttribute(HttpClientContext.CREDS_PROVIDER, credsProvider);
    return authContext;
  }


}
