package org.gbif.doi.services.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.DoiException;
import org.gbif.doi.DoiHttpException;
import org.gbif.doi.DoiService;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.doi.services.ServiceConfig;
import org.gbif.utils.HttpUtil;
import org.gbif.utils.file.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import javax.xml.parsers.ParserConfigurationException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DataciteServiceIT {
  // test prefix for DataCite, behaving like normal DOIs and occasionally purged
  private static final String TEST_PREFIX = "10.5072";
  private static final String GBIF_PREFIX = "10.15468";
  private static DoiService service;

  final static DOI FOREIGN_DOI = new DOI("10.6084/m9.figshare.821213");
  final static URI TEST_TARGET = URI.create("http://www.gbif.org/datasets");

  @BeforeClass
  public static void setup() throws IOException, ParserConfigurationException, SAXException {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    InputStream dc = FileUtils.classpathStream("datacite.yaml");
    ServiceConfig cfg = mapper.readValue(dc, ServiceConfig.class);
    System.out.println(cfg);
    service = new DataciteService(HttpUtil.newMultithreadedClient(10000, 3, 2), cfg);
  }

  @Test
  public void testGet() throws Exception {
    final DOI doi = new DOI(TEST_PREFIX, "gbif-"+System.nanoTime());
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    service.register(doi, TEST_TARGET);
    assertEquals(TEST_TARGET, service.get(doi));
  }

  @Test(expected = DoiHttpException.class)
  public void testGetForeign() throws Exception {
    // this DOI does not belong to GBIF and we cannot read it...
    service.get(FOREIGN_DOI);
  }

  @Test
  public void testReserve() throws Exception {
    final DOI doi = new DOI(TEST_PREFIX, "gbif-"+System.nanoTime());
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    try {
      service.reserve(doi, meta);
      fail("DOI was reserved already, expected DoiExistsException");
    } catch (DoiException e) {

    }
  }

  @Test
  public void testReserveRandom() throws Exception {
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata();
    DOI doi = service.reserveRandom(TEST_PREFIX, 4, meta);
    System.out.println("Reserved random id " + doi);
  }

  @Test
  public void testDeleteReserved() throws Exception {
    final DOI doi = new DOI(TEST_PREFIX, "gbif-"+System.nanoTime());
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    // now delete it and reserving again should work
    service.delete(doi);
    service.reserve(doi, meta);
    service.delete(doi);
  }

  @Test
  public void testDeleteRegistered() throws Exception {
    final DOI doi = new DOI(TEST_PREFIX, "gbif-"+System.nanoTime());
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    service.register(doi, TEST_TARGET);
    assertEquals(TEST_TARGET, service.get(doi));
    // now delete it to remove metadata, the registered target remains
    service.delete(doi);
    assertEquals(TEST_TARGET, service.get(doi));
    // reserving again should work
    service.reserve(doi, meta);
  }

  @Test
  public void testUpdateRegistered() throws Exception {
    final DOI doi = new DOI(TEST_PREFIX, "gbif-"+System.nanoTime());
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    service.register(doi, TEST_TARGET);
    assertEquals(TEST_TARGET, service.get(doi));

    final URI target2 = TEST_TARGET.resolve("subsub");
    service.update(doi, target2);
    assertEquals(target2, service.get(doi));
  }

  @Test
  public void testRegister() throws Exception {
    final DOI doi = new DOI(TEST_PREFIX, "gbif-"+System.nanoTime());
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    service.register(doi, TEST_TARGET);
    assertEquals(TEST_TARGET, service.get(doi));
    try {
      // try again, this should fail!
      service.register(doi, TEST_TARGET);
      fail("DOI was registered already, expected DoiExistsException");
    } catch (DoiException e) {
      System.out.println(e);
    }
  }

  @Test(expected = DoiException.class)
  public void testRegisterFail() throws Exception {
    final DOI doi = new DOI(TEST_PREFIX, "gbif-"+System.nanoTime());
    // registering without previous reservation should throw an error
    service.register(doi, TEST_TARGET);
  }

  @Test
  @Ignore("This is only to manually test the real prefix behavior. Only use the test prefix for regular tests")
  public void testRealGBIFPrefix() throws Exception {

    final DOI doi = new DOI(GBIF_PREFIX, "test."+System.nanoTime());
    System.out.println(doi);
    URI url = service.get(doi);
    System.out.println(url);

    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    url = service.get(doi);
    System.out.println(url);

    service.register(doi, TEST_TARGET);
    url = service.get(doi);
    System.out.println(url);
  }
}