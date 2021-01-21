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
import org.gbif.doi.service.datacite.DataCiteValidator;
import org.gbif.doi.util.Difference.DifferenceItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("ConstantConditions")
public class MetadataUtilsTest {

  private static String metadataXmlLowerCaseIdentifier;
  private static String metadataXmlLowerCaseIdentifierAnother;
  private static String metadataXmlUpperCaseIdentifier;
  private static String metadataXmlVersion3;

  @BeforeAll
  public static void before() throws Exception {
    metadataXmlLowerCaseIdentifier = readFileData("metadata/datacite-example-full-v4.xml");
    metadataXmlUpperCaseIdentifier =
        readFileData("metadata/datacite-example-full-v4-uppercase-identifier.xml");
    metadataXmlLowerCaseIdentifierAnother =
        readFileData("metadata/datacite-example-full-v4-another.xml");
    metadataXmlVersion3 = readFileData("metadata/datacite-example-full-v3.xml");
  }

  private static String readFileData(String s) throws IOException {
    return new String(
        Files.readAllBytes(Paths.get(ClassLoader.getSystemClassLoader().getResource(s).getFile())));
  }

  @Test
  public void testEqualInsensitiveIdentifierDataCiteMetadataSources() throws Exception {
    // given
    DataCiteMetadata uppercaseIdentifierMetadata =
        DataCiteValidator.fromXml(metadataXmlLowerCaseIdentifier);
    DataCiteMetadata lowercaseIdentifierMetadata =
        DataCiteValidator.fromXml(metadataXmlUpperCaseIdentifier);

    // when
    boolean metadataEqualsResult =
        MetadataUtils.metadataEquals(uppercaseIdentifierMetadata, lowercaseIdentifierMetadata);
    boolean regularEqualsResult =
        Objects.equals(uppercaseIdentifierMetadata, lowercaseIdentifierMetadata);

    // then
    assertTrue(metadataEqualsResult);
    assertFalse(regularEqualsResult);
  }

  @Test
  public void testEqualInsensitiveIdentifierStringSources() {
    // when
    boolean metadataEqualsResult =
        MetadataUtils.metadataEquals(
            metadataXmlUpperCaseIdentifier, metadataXmlLowerCaseIdentifier);
    boolean regularEqualsResult =
        Objects.equals(metadataXmlUpperCaseIdentifier, metadataXmlLowerCaseIdentifier);

    // then
    assertTrue(metadataEqualsResult);
    assertFalse(regularEqualsResult);
  }

  @Test
  public void testEqualOneOrBothMetadataNull() {
    // when
    boolean firstMetadataNullResult =
        MetadataUtils.metadataEquals(null, metadataXmlUpperCaseIdentifier);
    boolean secondMetadataNullResult =
        MetadataUtils.metadataEquals(metadataXmlUpperCaseIdentifier, null);
    boolean bothMetadataNullResult = MetadataUtils.metadataEquals((String) null, null);

    // then
    assertFalse(firstMetadataNullResult);
    assertFalse(secondMetadataNullResult);
    assertTrue(bothMetadataNullResult);
  }

  @Test
  public void testEqualAllowOnlyRecentMetadata() {
    // when
    boolean result = MetadataUtils.metadataEquals(metadataXmlVersion3, metadataXmlVersion3);

    // then
    assertFalse(result);
  }

  @Test
  public void testMetadataDifference() {
    // when
    Difference metadataDifference =
        MetadataUtils.metadataDifference(
            metadataXmlLowerCaseIdentifier, metadataXmlLowerCaseIdentifierAnother);

    // then
    List<String> fields =
        metadataDifference.getItems().stream()
            .map(DifferenceItem::getFieldName)
            .collect(Collectors.toList());
    assertEquals(3, fields.size());
    assertTrue(fields.contains("creators"));
    assertTrue(fields.contains("publicationYear"));
    assertTrue(fields.contains("dates"));
    assertEquals(Difference.Status.COMPATIBLE_OBJECTS, metadataDifference.getComparisonStatus());
  }

  @Test
  public void testMetadataDifferenceOneOrBothArgumentsNull() {
    // when
    Difference metadataDifferenceFirstArgumentNull =
        MetadataUtils.metadataDifference(null, metadataXmlLowerCaseIdentifier);
    Difference metadataDifferenceSecondArgumentNull =
        MetadataUtils.metadataDifference(metadataXmlLowerCaseIdentifier, null);
    Difference metadataDifferenceBothArgumentNull = MetadataUtils.metadataDifference(null, null);

    // then
    assertEquals(0, metadataDifferenceFirstArgumentNull.getItems().size());
    assertEquals(0, metadataDifferenceSecondArgumentNull.getItems().size());
    assertEquals(0, metadataDifferenceBothArgumentNull.getItems().size());
    assertEquals(
        Difference.Status.NULL_OBJECTS, metadataDifferenceFirstArgumentNull.getComparisonStatus());
    assertEquals(
        Difference.Status.NULL_OBJECTS, metadataDifferenceSecondArgumentNull.getComparisonStatus());
    assertEquals(
        Difference.Status.NULL_OBJECTS, metadataDifferenceBothArgumentNull.getComparisonStatus());
  }

  @Test
  public void testMetadataDifferenceIncompatibleMetadataVersion() {
    // when
    Difference metadataDifferenceFirstArgumentIncompatibleMetadata =
        MetadataUtils.metadataDifference(metadataXmlLowerCaseIdentifier, metadataXmlVersion3);
    Difference metadataDifferenceSecondArgumentIncompatibleMetdata =
        MetadataUtils.metadataDifference(metadataXmlVersion3, metadataXmlLowerCaseIdentifier);
    Difference metadataDifferenceBothArgumentIncompatibleMetadata =
        MetadataUtils.metadataDifference(metadataXmlVersion3, metadataXmlVersion3);

    // then
    assertEquals(0, metadataDifferenceFirstArgumentIncompatibleMetadata.getItems().size());
    assertEquals(0, metadataDifferenceSecondArgumentIncompatibleMetdata.getItems().size());
    assertEquals(0, metadataDifferenceBothArgumentIncompatibleMetadata.getItems().size());
    assertEquals(
        Difference.Status.INCOMPATIBLE_OBJECTS,
        metadataDifferenceFirstArgumentIncompatibleMetadata.getComparisonStatus());
    assertEquals(
        Difference.Status.INCOMPATIBLE_OBJECTS,
        metadataDifferenceSecondArgumentIncompatibleMetdata.getComparisonStatus());
    assertEquals(
        Difference.Status.INCOMPATIBLE_OBJECTS,
        metadataDifferenceBothArgumentIncompatibleMetadata.getComparisonStatus());
  }
}
