package org.gbif.doi.services.ezid;


import org.gbif.doi.api.DoiRegistrarException;
import org.gbif.doi.util.HttpClientFactory;
import org.gbif.metadata.eml.Eml;
import org.gbif.metadata.eml.EmlFactory;
import org.gbif.utils.file.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class EzidServiceTest {
  // special prefix used for testing DOIs in DataCite, behaving like normal DOIs and occasionally purged
  private static final String TEST_DOI_PREFIX = "doi:10.5072/FK2";
  private static final String PUBLISHER = "Zoological Museum, Natural History Museum of Denmark";
  private static final String RESOURCE_TYPE = "Species observations";

  private EzidService service;
  private String doi;
  private File metadataFile;
  private Eml eml;

  @Before
  public void setup() throws IOException, ParserConfigurationException, SAXException {
    HttpClientFactory clientFactory = new HttpClientFactory(10, TimeUnit.SECONDS);
    service = new EzidService(clientFactory.provideHttpClient(), "apitest", "apitest");

    // construct DOI to reserve (using test prefix of course)
    doi = TEST_DOI_PREFIX + System.currentTimeMillis();
    // metadata file to write to
    metadataFile = File.createTempFile("datacite", ".xml");
    // construct Eml from file
    eml = EmlFactory.build(FileUtils.classpathStream("metadata/eml_sample.xml"));
  }

  @Test
  public void testReserve() throws DoiRegistrarException {
    try {
      service.reserve(metadataFile, eml, doi, PUBLISHER, RESOURCE_TYPE);
    } catch (DoiRegistrarException e) {
      fail("Reserve DOI failed with [" + e.getErrorCode().toString() + "] error: " + e.getMessage());
    }
  }

  @Test
  public void testFormatEzidUri() throws URISyntaxException {
    assertEquals("https://ezid.cdlib.org/id/doi:10.1234/TNG7Y", service.createEzidUri("10.1234/TNG7Y").toString());
    assertEquals("https://ezid.cdlib.org/id/doi:10.1234/TNG7Y", service.createEzidUri("doi:10.1234/TNG7Y").toString());
  }
}
