package org.gbif.doi.service.datacite;

import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.utils.file.FileUtils;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

public class DataciteValidatorTest {
  // we only use this to serialize XML
  private static final JAXBContext context;
  static {
    try {
      context = JAXBContext.newInstance(DataCiteMetadata.class);
    } catch (JAXBException e) {
      throw new IllegalStateException("Fail to setup JAXB", e);
    }
  }


  public static String toXml(DataCiteMetadata data) throws JAXBException {
    // (un)marshaller are not thread safe and need to be created on each postOrPut
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    StringWriter writer = new StringWriter();
    m.marshal(data, writer);
    writer.flush();
    return writer.toString();
  }

  @Test
  public void testValidateMetadata() throws Exception {
    DataciteValidator.validateMetadata(FileUtils.classpathStream("metadata/datacite-example-full-v3.1.xml"));
    DataciteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal.xml"));
  }

  @Test
  public void testValidateMetadataBean() throws Exception {
    DataciteValidator.validateMetadata(toXml(DataCiteMetadataTest.testMetadata()));
  }
}