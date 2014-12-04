package org.gbif.doi.services.ezid;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.services.ServiceConfig;
import org.gbif.utils.HttpUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import static org.junit.Assert.assertEquals;

public class EzidServiceTest {
  private static final String DOI_PREFIX = "doi:10.5072/FK2";
  private EzidService service;

  @Before
  public void setup() throws IOException, ParserConfigurationException, SAXException {
    ServiceConfig cfg = new ServiceConfig();
    cfg.setUsername("apitest");
    cfg.setPassword("apitest");
    service = new EzidService(HttpUtil.newMultithreadedClient(2000, 10, 10), cfg);
  }

  @Test
  @Ignore
  public void testReserve() throws Exception {

  }

  @Test
  public void testFormatEzidUri() throws URISyntaxException {
    assertEquals(URI.create("https://ezid.cdlib.org/id/doi:10.1234/TNG7Y"), service.ezidUri(new DOI("10.1234/TNG7Y")));
    assertEquals(URI.create("https://ezid.cdlib.org/id/doi:10.1234/TNG7Y"), service.ezidUri(new DOI("doi:10.1234/TNG7Y")));
  }
}