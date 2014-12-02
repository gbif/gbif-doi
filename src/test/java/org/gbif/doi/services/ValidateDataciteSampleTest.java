package org.gbif.doi.services;

import org.gbif.utils.file.FileUtils;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;


/**
 * For validation of DataCite metadata files.
 */
public class ValidateDataciteSampleTest {

  @Test
  public void validateSample() throws IOException, SAXException {
    // DataCite metadata file to validate
    DataciteValidator.validateMetadata(FileUtils.classpathStream("metadata/datacite-example-full-v3.1.xml"));
  }

}
