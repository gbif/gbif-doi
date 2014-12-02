package org.gbif.doi.services;

import org.gbif.utils.file.FileUtils;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;


/**
 * For validation of DataCite metadata files.
 */
public class ValidateDataciteSampleTest {

  private static final Logger LOG = LoggerFactory.getLogger(ValidateDataciteSampleTest.class);

  @Test
  public void validateSample() throws IOException, SAXException {
    // DataCite metadata file to validate
    DataciteValidator.validateMetadata(FileUtils.classpathStream("metadata/datacite_sample.xml"));
  }

}
