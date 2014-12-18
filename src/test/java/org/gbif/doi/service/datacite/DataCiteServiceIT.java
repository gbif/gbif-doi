package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.api.model.common.DoiData;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.doi.service.DoiService;
import org.gbif.doi.service.ServiceConfig;
import org.gbif.utils.HttpUtil;
import org.gbif.utils.file.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DataCiteServiceIT extends DoiServiceIT {
  private static DataCiteService service;

  // test prefix for DataCite, behaving like normal DOIs and occasionally purged
  public DataCiteServiceIT() {
    super("10.5072", "gbif.", setup());
  }

  private static DoiService setup() {
    try {
      ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
      InputStream dc = FileUtils.classpathStream("datacite.yaml");
      ServiceConfig cfg = mapper.readValue(dc, ServiceConfig.class);
      System.out.println(cfg);
      service = new DataCiteService(HttpUtil.newMultithreadedClient(10000, 3, 2), cfg);
      return service;
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * DataCite does only allow you to read your own identifiers.
   * This is different how EZID handles it, hence we put the test here and not in the base class.
   */
  @Test
  public void testGetForeign() throws Exception {
    // this DOI does not belong to GBIF and we cannot read it...
    assertNull(service.resolve(FOREIGN_DOI));
  }

  @Test
  @Ignore("This is only to manually test the real prefix behavior. Only use the test prefix for regular tests")
  public void testRealGBIFPrefix() throws Exception {

    final DOI doi = new DOI(DOI.GBIF_PREFIX, "test."+System.nanoTime());
    System.out.println(doi);
    DoiData status = service.resolve(doi);
    System.out.println(status);

    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    status = service.resolve(doi);
    System.out.println(status);

    service.register(doi, TEST_TARGET, meta);
    status = service.resolve(doi);
    System.out.println(status);
  }

  @Test
  public void testDataCiteUri() throws Exception {
    assertEquals(URI.create("https://mds.datacite.org/doi/10.1234/tng7y"), service.doiUri(new DOI("10.1234/TNG7Y")));
    assertEquals(URI.create("https://mds.datacite.org/metadata/10.1234/tng7y"), service.metadataUri(new DOI("10.1234/TNG7Y")));
  }
}