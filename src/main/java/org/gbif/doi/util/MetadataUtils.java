/*
 * Copyright 2020 Global Biodiversity Information Facility (GBIF)
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
package org.gbif.doi.util;

import org.gbif.doi.metadata.datacite.DataCiteMetadata;

import com.google.common.base.Objects;

/** Utils related {@link DataCiteMetadata}. */
public final class MetadataUtils {

  private MetadataUtils() {}

  /**
   * Compare two DataCite metadata objects. Unlike {@link DataCiteMetadata#equals(Object)} the
   * method is case-insensitive for {@link DataCiteMetadata.Identifier#getValue()}. This is needed
   * because the DataCite keeps DOIs in uppercase, and GBIF does in lowercase.
   */
  public static boolean equal(DataCiteMetadata metadata1, DataCiteMetadata metadata2) {
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
        && Objects.equal(metadata1.getCreators(), metadata2.getCreators())
        && Objects.equal(metadata1.getTitles(), metadata2.getTitles())
        && Objects.equal(metadata1.getPublisher(), metadata2.getPublisher())
        && Objects.equal(metadata1.getPublicationYear(), metadata2.getPublicationYear())
        && Objects.equal(metadata1.getResourceType(), metadata2.getResourceType())
        && Objects.equal(metadata1.getSubjects(), metadata2.getSubjects())
        && Objects.equal(metadata1.getContributors(), metadata2.getContributors())
        && Objects.equal(metadata1.getDates(), metadata2.getDates())
        && Objects.equal(metadata1.getLanguage(), metadata2.getLanguage())
        && Objects.equal(metadata1.getAlternateIdentifiers(), metadata2.getAlternateIdentifiers())
        && Objects.equal(metadata1.getRelatedIdentifiers(), metadata2.getRelatedIdentifiers())
        && Objects.equal(metadata1.getSizes(), metadata2.getSizes())
        && Objects.equal(metadata1.getFormats(), metadata2.getFormats())
        && Objects.equal(metadata1.getVersion(), metadata2.getVersion())
        && Objects.equal(metadata1.getRightsList(), metadata2.getRightsList())
        && Objects.equal(metadata1.getDescriptions(), metadata2.getDescriptions())
        && Objects.equal(metadata1.getGeoLocations(), metadata2.getGeoLocations())
        && Objects.equal(metadata1.getFundingReferences(), metadata2.getFundingReferences());
  }
}
