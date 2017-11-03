package org.gbif.doi.service.ezid;

import org.gbif.api.model.common.DOI;
import org.gbif.api.model.common.DoiData;
import org.gbif.api.model.common.DoiStatus;
import org.gbif.doi.service.ServiceConfig;
import org.gbif.doi.service.datacite.DoiServiceIT;
import org.gbif.utils.HttpUtil;

import java.net.URI;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore("Ezid test IDs are not found")
public class EzidServiceIT extends DoiServiceIT {
  private static final String TEST_PREFIX = "10.5072";
  private static final String TEST_SHOULDER = "FK2";
  private static EzidService service;

  public EzidServiceIT() {
    super(TEST_PREFIX, TEST_SHOULDER+".gbif.", setup());
  }

  public static EzidService setup() {
    ServiceConfig cfg = new ServiceConfig("apitest", "apitest");
    service = new EzidService(HttpUtil.newMultithreadedClient(10000, 2, 2), cfg);
    return service;
  }

  /**
   * EZID allows you to read any identifier.
   */
  @Test
  public void testGetForeign() throws Exception {
    // this DOI does not belong to GBIF and we cannot read it...
    assertEquals(
      new DoiData(DoiStatus.REGISTERED, URI.create("http://figshare.com/articles/5000_random_journal_article_CrossRef_DOIs_from_2012/821213")),
      service.resolve(FOREIGN_DOI));
  }

  @Test
  public void testFormatEzidUri() throws Exception {
    assertEquals(URI.create("https://ezid.cdlib.org/id/doi:10.1234/tng7y"), service.idUri(new DOI("10.1234/TNG7Y")));
    assertEquals(URI.create("https://ezid.cdlib.org/id/doi:10.1234/tng7y"), service.idUri(new DOI("doi:10.1234/TNG7Y")));
  }
}
