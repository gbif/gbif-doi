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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class MetadataUtilsTest {

  private static String metadataXmlLowerCaseIdentifier;
  private static String metadataXmlLowerCaseIdentifierAnother;
  private static String metadataXmlUpperCaseIdentifier;

  @BeforeClass
  public static void before() throws Exception {
    metadataXmlLowerCaseIdentifier = readFileData("metadata/datacite-example-full-v4.xml");
    metadataXmlUpperCaseIdentifier =
        readFileData("metadata/datacite-example-full-v4-uppercase-identifier.xml");
    metadataXmlLowerCaseIdentifierAnother =
        readFileData("metadata/datacite-example-full-v4-another.xml");
  }

  @NotNull
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
  public void testMetadataDifference() {
    // when
    Difference metadataDifference =
        MetadataUtils.metadataDifference(
            metadataXmlLowerCaseIdentifier, metadataXmlLowerCaseIdentifierAnother);

    // then
    List<String> fields =
        metadataDifference.getDifference().stream()
            .map(DifferenceItem::getFieldName)
            .collect(Collectors.toList());
    assertEquals(3, fields.size());
    assertTrue(fields.contains("creators"));
    assertTrue(fields.contains("publicationYear"));
    assertTrue(fields.contains("dates"));
  }

  @Test
  public void testMetadataDifferenceBothArgumentNull() {
    // when
    Difference metadataDifference = MetadataUtils.metadataDifference(null, null);

    // then
    assertEquals(0, metadataDifference.getDifference().size());
  }

  @Test
  public void testMetadataDifferenceOneArgumentNull() {
    // when
    Difference metadataDifference =
        MetadataUtils.metadataDifference(null, metadataXmlLowerCaseIdentifier);

    // then
    assertEquals(0, metadataDifference.getDifference().size());
  }

  @Test
  public void testMetadataDifferenceEquals() {
    // when
    Difference metadataDifference1 =
        MetadataUtils.metadataDifference(
            metadataXmlLowerCaseIdentifier, metadataXmlLowerCaseIdentifierAnother);
    Difference metadataDifference2 =
        MetadataUtils.metadataDifference(
            metadataXmlLowerCaseIdentifierAnother, metadataXmlLowerCaseIdentifier);
    System.out.println(metadataDifference1);
    System.out.println(metadataDifference2);

    List<DifferenceItem> differenceItems1 = new ArrayList<>(metadataDifference1.getDifference());
    List<DifferenceItem> differenceItems2 = new ArrayList<>(metadataDifference2.getDifference());

    boolean result = differenceItems1.get(0).equals(differenceItems2.get(0));

    // then
    assertFalse(result);
  }
}
