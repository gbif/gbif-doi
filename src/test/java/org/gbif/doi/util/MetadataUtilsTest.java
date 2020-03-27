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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class MetadataUtilsTest {

  private static String metadataXmlLowerCaseIdentifier;
  private static String metadataXmlUpperCaseIdentifier;

  @BeforeClass
  public static void before() throws Exception {
    metadataXmlLowerCaseIdentifier =
        new String(
            Files.readAllBytes(
                Paths.get(
                    ClassLoader.getSystemClassLoader()
                        .getResource("metadata/datacite-example-full-v4.xml")
                        .getFile())));

    metadataXmlUpperCaseIdentifier =
        new String(
            Files.readAllBytes(
                Paths.get(
                    ClassLoader.getSystemClassLoader()
                        .getResource("metadata/datacite-example-full-v4-uppercase-identifier.xml")
                        .getFile())));
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
        MetadataUtils.metadataEquals(metadataXmlUpperCaseIdentifier, metadataXmlLowerCaseIdentifier);
    boolean regularEqualsResult =
        Objects.equals(metadataXmlUpperCaseIdentifier, metadataXmlLowerCaseIdentifier);

    // then
    assertTrue(metadataEqualsResult);
    assertFalse(regularEqualsResult);
  }
}
