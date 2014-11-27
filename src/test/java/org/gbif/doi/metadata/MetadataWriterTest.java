package org.gbif.doi.metadata;

import org.gbif.metadata.eml.Eml;
import org.gbif.metadata.eml.EmlFactory;
import org.gbif.utils.file.FileUtils;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;

import freemarker.template.TemplateException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;

/**
 * For testing writing DataCite metadata files from EML files.
 */
public class MetadataWriterTest {
  private File file;
  private Eml eml;
  private static final String DOI = "10.5072/DT6W3X";
  private static final String PUBLISHER = "Zoological Museum, Natural History Museum of Denmark";
  private static final String RESOURCE_TYPE = "Species observations";

  @Before
  public void setup() throws IOException, ParserConfigurationException, SAXException {
    // construct Eml from file
    eml = EmlFactory.build(FileUtils.classpathStream("metadata/eml_sample.xml"));
    // make temporary file to output DataCite metadata to
    file = File.createTempFile("datacite", ".xml");
  }

  /**
   * Construct DataCite metadata file from Eml object, and validate it.
   */
  @Test
  public void testWriteMetadataFile() throws IOException, TemplateException {
    MetadataWriter.writeMetadataFile(file, eml, DOI, PUBLISHER, RESOURCE_TYPE);
    try {
      ValidatorFactory.getDataciteValidator().validate(new StreamSource(file));
    } catch (Exception e) {
      fail("DataCite metadata file " + file.getAbsolutePath() + " does not validate!");
    }
  }
}
