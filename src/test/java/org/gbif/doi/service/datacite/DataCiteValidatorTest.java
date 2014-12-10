package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.utils.file.FileUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataCiteValidatorTest {

  @Test
  public void testValidateMetadata() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/datacite-example-full-v3.1.xml"));
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal.xml"));
  }

  @Test
  public void testValidateMetadataBean() throws Exception {
    final DOI doi = new DOI("10.1234/gbif");
    DataCiteValidator.validateMetadata(DataCiteValidator.toXml(doi, DataCiteMetadataTest.testMetadata()));
  }

  @Test
  public void testRoundtrip() throws Exception {
    final DOI doi = new DOI("10.1234/gbif");

    DataCiteMetadata m = DataCiteValidator.fromXml(FileUtils.classpathStream("metadata/datacite-example-full-v3.1.xml"));
    String xml = DataCiteValidator.toXml(doi, m);

    DataCiteMetadata m2 = DataCiteValidator.fromXml(xml);
    String xml2 = DataCiteValidator.toXml(doi, m2);

    assertEquals(xml, xml2);
  }
}