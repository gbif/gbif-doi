package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.InvalidMetadataException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.google.common.base.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * For the validation of DataCite metadata files.
 */
public final class DataCiteValidator {
  private static final Logger LOG = LoggerFactory.getLogger(DataCiteValidator.class);
  private static final String DATACITE_XSD_LOCATION = "http://schema.datacite.org/meta/kernel-4/metadata.xsd";
  private static final String DATACITE_SCHEMA_LOCATION = "http://datacite.org/schema/kernel-4 " + DATACITE_XSD_LOCATION;
  //lazy initialized
  private static Schema dataciteSchema;
  private static final JAXBContext CONTEXT;

  private DataCiteValidator() {
  }

  static {
    try {
      CONTEXT = JAXBContext.newInstance(DataCiteMetadata.class);
    } catch (JAXBException e) {
      throw new IllegalStateException("Fail to setup JAXB", e);
    }
  }

  /**
   * Produces a validated xml representation of the data cite metadata.
   * The DOI inside the metadata is overwritten to always represent the given DOI
   * and the generated XML is validated according to the datacite xsd schema.
   *
   * @return xml string
   * @throws InvalidMetadataException if the generated xml failed validation, e.g. missing mandatory elements
   */
  public static String toXml(DOI doi, DataCiteMetadata data) throws InvalidMetadataException {
    // make sure we use the right doi inside the metadata
    data.setIdentifier(DataCiteMetadata.Identifier.builder()
        .withValue(doi.getDoiName())
        .withIdentifierType("DOI")
        .build()
    );
    LOG.debug("Metadata XML passed validation {}", doi);
    return toXml(data, true);
  }

  /**
   * Produces a validated xml representation of the data cite metadata.
   * The boolean flag 'validate' it is used to specify if it should be validated.
   * The generated XML is validated according to the datacite xsd schema.
   *
   * @return xml string
   * @throws InvalidMetadataException if the generated xml failed validation, e.g. missing mandatory elements
   */
  public static String toXml(DataCiteMetadata data, boolean validate) throws InvalidMetadataException {
    // (un)marshaller are not thread safe and need to be created on each authCall
    try (StringWriter writer = new StringWriter()) {
      Marshaller m = CONTEXT.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, DATACITE_SCHEMA_LOCATION);

      m.marshal(data, writer);
      writer.flush();

      String xml = writer.toString();
      if (validate) {
        // validate the xml before we return it
        validateMetadata(xml);
      }
      return xml;
    } catch (JAXBException | IOException e) {
      throw new InvalidMetadataException(e);
    }
  }

  /**
   * Create metadata from String XML.
   *
   * @param xml string metadata
   * @return DataCiteMetadata
   * @throws JAXBException in case of unmarshalling problems
   */
  public static DataCiteMetadata fromXml(String xml) throws JAXBException {
    return fromXml(new ByteArrayInputStream(xml.getBytes(Charsets.UTF_8)));
  }

  /**
   * Create metadata from byte stream.
   *
   * @param in byte stream
   * @return DataCiteMetadata
   * @throws JAXBException in case of unmarshalling problems
   */
  public static DataCiteMetadata fromXml(InputStream in) throws JAXBException {
    // (un)marshaller are not thread safe and need to be created on each call
    Unmarshaller m = CONTEXT.createUnmarshaller();
    return (DataCiteMetadata) m.unmarshal(in);
  }

  /**
   * Validate metadata.
   *
   * @param xml DataCite xml metadata to validate (String)
   * @throws InvalidMetadataException in case of invalid metadata
   */
  public static void validateMetadata(String xml) throws InvalidMetadataException {
    validateMetadata(new StreamSource(new StringReader(xml)));
  }

  /**
   * Validate metadata.
   *
   * @param xml DataCite xml metadata to validate (byte stream)
   * @throws InvalidMetadataException in case of invalid metadata
   */
  public static void validateMetadata(InputStream xml) throws InvalidMetadataException {
    validateMetadata(new StreamSource(xml));
  }

  /**
   * Validate metadata.
   *
   * @param source DataCite xml metadata to validate (abstract source)
   * @throws InvalidMetadataException in case of invalid metadata
   */
  public static void validateMetadata(Source source) throws InvalidMetadataException {
    try {
      getValidator().validate(source);
      LOG.debug("Metadata XML passed validation");
    } catch (SAXException e) {
      throw new InvalidMetadataException(e);
    } catch (IOException e) {
      // cant happen, we had a string in memory already!
      throw new IllegalStateException(e);
    }
  }

  /**
   * Lazy create the dataciteSchema and return a new instance of validator on each call.
   * Validator instances are NOT thread-safe.
   *
   * @return validator
   * @throws SAXException in case of xml parsing exceptions
   */
  private synchronized static Validator getValidator() throws SAXException {
    if (dataciteSchema == null) {
      String schemaLang = "http://www.w3.org/2001/XMLSchema";
      // resolve validation driver:
      SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
      // create schema by reading it from an URL:
      dataciteSchema = factory.newSchema(new StreamSource(DATACITE_XSD_LOCATION));
    }

    return dataciteSchema.newValidator();
  }

}
