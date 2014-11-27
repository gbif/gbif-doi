package org.gbif.doi.util;

import org.gbif.utils.HttpUtil;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.DefaultHttpClient;

/**
 * A factory that builds new Apache Http Clients to be used with the DOI service.
 *
 * This allows for easy swapping of implementations to make testing easier.
 */
public class HttpClientFactory {

  private static final int MAX_TOTAL_CONNECTIONS = 200;
  private static final int MAX_CONNECTIONS_PER_HOST = 20;

  private final int timeout;

  /**
   * Builds a new Factory.
   */
  public HttpClientFactory(long timeout, TimeUnit timeUnit) {
    long millis = TimeUnit.MILLISECONDS.convert(timeout, timeUnit);

    System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(millis));
    System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(millis));

    this.timeout = (int) millis;
  }

  public DefaultHttpClient provideHttpClient() {
    return HttpUtil.newMultithreadedClient(timeout, MAX_TOTAL_CONNECTIONS, MAX_CONNECTIONS_PER_HOST);
  }

}
