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
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Identifier;
import org.gbif.doi.service.datacite.DataCiteValidator;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class MetadataUtilsTest {

  private String metadataXml;

  @Before
  public void before() throws Exception {
    byte[] bytes =
        Files.readAllBytes(
            Paths.get(
                ClassLoader.getSystemClassLoader()
                    .getResource("metadata/datacite-example-full-v4.xml")
                    .getFile()));

    metadataXml = new String(bytes);
  }

  @Test
  public void testEqualInsensitiveIdentifier() throws Exception {
    DataCiteMetadata uppercaseIdentifierMetadata = DataCiteValidator.fromXml(metadataXml);
    uppercaseIdentifierMetadata.setIdentifier(
        Identifier.builder().withValue("10.21373/ABCD").withIdentifierType("DOI").build());

    DataCiteMetadata lowercaseIdentifierMetadata = DataCiteValidator.fromXml(metadataXml);
    lowercaseIdentifierMetadata.setIdentifier(
        Identifier.builder().withValue("10.21373/abcd").withIdentifierType("DOI").build());

    assertTrue(MetadataUtils.equal(uppercaseIdentifierMetadata, lowercaseIdentifierMetadata));
    assertNotEquals(uppercaseIdentifierMetadata, lowercaseIdentifierMetadata);
  }
}
