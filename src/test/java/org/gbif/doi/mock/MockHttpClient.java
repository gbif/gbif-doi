package org.gbif.doi.mock;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/**
 *
 * A mock CloseableHttpClient that will always return the same response code.
 * Mostly used to test handling of HTTP Error codes.
 *
 */
public class MockHttpClient extends CloseableHttpClient {

  private int expectedResponseCode;

  public MockHttpClient(int expectedResponseCode){
    this.expectedResponseCode = expectedResponseCode;
  }

  @Override
  protected CloseableHttpResponse doExecute(HttpHost target, HttpRequest request, HttpContext context)
          throws IOException, ClientProtocolException {
    return new MockCloseableHttpResponse(expectedResponseCode);
  }

  @Override
  public void close() throws IOException {

  }

  @Override
  public HttpParams getParams() {
    return null;
  }

  @Override
  public ClientConnectionManager getConnectionManager() {
    return null;
  }
}
