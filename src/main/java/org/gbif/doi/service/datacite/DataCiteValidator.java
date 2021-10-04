/*
 * Copyright 2021 Global Biodiversity Information Facility (GBIF)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.InvalidMetadataException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/** For the validation of DataCite metadata files. */
public final class DataCiteValidator {
  private static final Logger LOG = LoggerFactory.getLogger(DataCiteValidator.class);

  private static final String DATACITE_XSD_LOCATION =
      "http://schema.datacite.org/meta/kernel-4/metadata.xsd";
  private static final String DATACITE_SCHEMA_LOCATION =
      "http://datacite.org/schema/kernel-4 " + DATACITE_XSD_LOCATION;
  private static final String SCHEMA_LANG = "http://www.w3.org/2001/XMLSchema";

  private static final Schema DATACITE_SCHEMA;
  private static final JAXBContext CONTEXT;

  private DataCiteValidator() {}

  static {
    try {
      SchemaFactory factory = SchemaFactory.newInstance(SCHEMA_LANG);
      DATACITE_SCHEMA = factory.newSchema(new StreamSource(DATACITE_XSD_LOCATION));
      CONTEXT = JAXBContext.newInstance(DataCiteMetadata.class);
    } catch (JAXBException | SAXException e) {
      throw new IllegalStateException("Fail to setup JAXB", e);
    }
  }

  /**
   * Produces a validated xml representation of the data cite metadata. The DOI inside the metadata
   * is overwritten to always represent the given DOI and the generated XML is validated according
   * to the datacite xsd schema.
   *
   * @return xml string
   * @throws InvalidMetadataException if the generated xml failed validation, e.g. missing mandatory
   *     elements
   */
  public static String toXml(DOI doi, DataCiteMetadata data) throws InvalidMetadataException {
    // make sure we use the right doi inside the metadata
    data.setIdentifier(
        DataCiteMetadata.Identifier.builder()
            .withValue(doi.getDoiName())
            .withIdentifierType("DOI")
            .build());
    LOG.debug("Metadata XML is being validated {}", doi);
    return toXml(data, true);
  }

  /**
   * Produces a validated xml representation of the data cite metadata. The boolean flag 'validate'
   * it is used to specify if it should be validated. The generated XML is validated according to
   * the datacite xsd schema.
   *
   * @return xml string
   * @throws InvalidMetadataException if the generated xml failed validation, e.g. missing mandatory
   *     elements
   */
  public static String toXml(DataCiteMetadata data, boolean validate)
      throws InvalidMetadataException {
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
    } catch (JAXBException e) {
      throw new InvalidMetadataException(e);
    } catch (IOException e) {
      throw new IllegalStateException(e);
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
    return fromXml(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
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
      final Validator validator = getValidator();
      validator.validate(source);
      LOG.debug("Metadata XML passed validation");
    } catch (SAXException e) {
      throw new InvalidMetadataException(e);
    } catch (IOException e) {
      // cant happen, we had a string in memory already!
      throw new IllegalStateException(e);
    }
  }

  /**
   * A new instance of validator on each call. Validator instances are NOT thread-safe.
   *
   * @return validator
   */
  private static synchronized Validator getValidator() throws SAXException {
    final Validator validator = DATACITE_SCHEMA.newValidator();
    validator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
    validator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
    return validator;
  }
}
