/*
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
package org.gbif.doi.util;

import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.datacite.DataCiteValidator;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Utils related {@link DataCiteMetadata}. */
public final class MetadataUtils {

  private static final Logger LOG = LoggerFactory.getLogger(MetadataUtils.class);

  public static final String XMLNS_METADATA_SCHEMA_VERSION_4 =
      "xmlns=\"http://datacite.org/schema/kernel-4\"";

  private MetadataUtils() {}

  /**
   * Compare two DataCite metadata objects. Unlike {@link DataCiteMetadata#equals(Object)} the
   * method is case-insensitive for {@link DataCiteMetadata.Identifier#getValue()}. This is needed
   * because the DataCite keeps DOIs in uppercase, and GBIF does in lowercase.
   */
  public static boolean metadataEquals(DataCiteMetadata metadata1, DataCiteMetadata metadata2) {
    if (metadata1 == null && metadata2 == null) {
      return true;
    }

    if (metadata1 == null || metadata2 == null) {
      return false;
    }

    return metadata1
            .getIdentifier()
            .getIdentifierType()
            .equals(metadata2.getIdentifier().getIdentifierType())
        && metadata1
            .getIdentifier()
            .getValue()
            .equalsIgnoreCase(metadata2.getIdentifier().getValue())
        && Objects.equals(metadata1.getCreators(), metadata2.getCreators())
        && Objects.equals(metadata1.getTitles(), metadata2.getTitles())
        && Objects.equals(metadata1.getPublisher(), metadata2.getPublisher())
        && Objects.equals(metadata1.getPublicationYear(), metadata2.getPublicationYear())
        && Objects.equals(metadata1.getResourceType(), metadata2.getResourceType())
        && Objects.equals(metadata1.getSubjects(), metadata2.getSubjects())
        && Objects.equals(metadata1.getContributors(), metadata2.getContributors())
        && Objects.equals(metadata1.getDates(), metadata2.getDates())
        && Objects.equals(metadata1.getLanguage(), metadata2.getLanguage())
        && Objects.equals(metadata1.getAlternateIdentifiers(), metadata2.getAlternateIdentifiers())
        && Objects.equals(metadata1.getRelatedIdentifiers(), metadata2.getRelatedIdentifiers())
        && Objects.equals(metadata1.getSizes(), metadata2.getSizes())
        && Objects.equals(metadata1.getFormats(), metadata2.getFormats())
        && Objects.equals(metadata1.getVersion(), metadata2.getVersion())
        && Objects.equals(metadata1.getRightsList(), metadata2.getRightsList())
        && Objects.equals(metadata1.getDescriptions(), metadata2.getDescriptions())
        && Objects.equals(metadata1.getGeoLocations(), metadata2.getGeoLocations())
        && Objects.equals(metadata1.getFundingReferences(), metadata2.getFundingReferences());
  }

  /**
   * Compare two metadata objects. First convert them to {@link DataCiteMetadata} and apply {@link
   * MetadataUtils#metadataEquals(DataCiteMetadata, DataCiteMetadata)} afterwards.
   */
  public static boolean metadataEquals(String xmlMetadata1, String xmlMetadata2) {
    if (xmlMetadata1 == null && xmlMetadata2 == null) {
      return true;
    }

    if (xmlMetadata1 == null || xmlMetadata2 == null) {
      return false;
    }

    if (isNotCompatibleMetadata(xmlMetadata1) || isNotCompatibleMetadata(xmlMetadata2)) {
      return false;
    }

    try {
      DataCiteMetadata dataCiteMetadata1 = DataCiteValidator.fromXml(xmlMetadata1);
      DataCiteMetadata dataCiteMetadata2 = DataCiteValidator.fromXml(xmlMetadata2);

      return metadataEquals(dataCiteMetadata1, dataCiteMetadata2);
    } catch (JAXBException e) {
      LOG.error("Invalid metadata", e);
    }

    return false;
  }

  public static boolean isCompatibleMetadata(String xmlMetadata) {
    return xmlMetadata.contains(XMLNS_METADATA_SCHEMA_VERSION_4);
  }

  public static boolean isNotCompatibleMetadata(String xmlMetadata) {
    return !xmlMetadata.contains(XMLNS_METADATA_SCHEMA_VERSION_4);
  }

  /** Compare two metadata objects and get {@link Difference} between them. */
  public static Difference metadataDifference(String xmlMetadata1, String xmlMetadata2) {
    Set<Difference.DifferenceItem> result = new LinkedHashSet<>();

    if (xmlMetadata1 == null || xmlMetadata2 == null) {
      LOG.error("Can't get difference: null argument(s)");
      return new Difference(Difference.Status.NULL_OBJECTS, result);
    }

    if (isNotCompatibleMetadata(xmlMetadata1) || isNotCompatibleMetadata(xmlMetadata2)) {
      LOG.error("Can't get difference: incompatible objects");
      return new Difference(Difference.Status.INCOMPATIBLE_OBJECTS, result);
    }

    try {
      DataCiteMetadata dataCiteMetadata1 = DataCiteValidator.fromXml(xmlMetadata1);
      DataCiteMetadata dataCiteMetadata2 = DataCiteValidator.fromXml(xmlMetadata2);

      Field[] declaredFields = DataCiteMetadata.class.getDeclaredFields();
      for (Field field : declaredFields) {
        field.setAccessible(true);
        Object value1 = field.get(dataCiteMetadata1);
        Object value2 = field.get(dataCiteMetadata2);

        if (!Objects.equals(value1, value2)) {
          result.add(new Difference.DifferenceItem(field.getName(), value1, value2));
        }
      }
    } catch (JAXBException e) {
      LOG.error("Invalid metadata", e);
    } catch (IllegalAccessException e) {
      LOG.error("Access exception", e);
    }

    return new Difference(Difference.Status.COMPATIBLE_OBJECTS, result);
  }
}
