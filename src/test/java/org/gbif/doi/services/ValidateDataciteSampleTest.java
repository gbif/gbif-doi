package org.gbif.doi.services;

import org.gbif.utils.file.FileUtils;

import java.io.File;
import java.net.MalformedURLException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import static org.junit.Assert.fail;


/**
 * For validation of DataCite metadata files.
 */
public class ValidateDataciteSampleTest {

  private static final Logger LOG = LoggerFactory.getLogger(ValidateDataciteSampleTest.class);

  @Test
  public void validateSample() throws MalformedURLException, SAXException {
    // DataCite metadata file to validate
    File sample = FileUtils.getClasspathFile("metadata/datacite_sample.xml");

    Validator validator = ValidatorFactory.getDataciteValidator();
    try {
      validator.validate(new StreamSource(sample));
      LOG.info("{} validates successfully with DataCite metadata schema", sample.getName());
    } catch (Exception e) {
      fail(sample.getName() + " does not validate with DataCite metadata schema: " + e.getMessage());
    }
  }

}
