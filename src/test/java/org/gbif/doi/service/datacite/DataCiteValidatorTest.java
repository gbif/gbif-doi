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
package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.doi.service.InvalidMetadataException;
import org.gbif.utils.file.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Test DataCiteValidator. */
public class DataCiteValidatorTest {

  private static final String DATACITE_FULL_EXAMPLE_PATH = "metadata/datacite-example-full-v4.xml";
  private static final String DATACITE_MINIMAL_EXAMPLE_PATH = "metadata/minimal-v4.xml";

  @Test
  public void testValidateMetadataDataCiteMetadataExamplesShouldBeValid() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
    DataCiteValidator.validateMetadata(FileUtils.classpathStream(DATACITE_MINIMAL_EXAMPLE_PATH));
  }

  @Test
  public void testRoundTripFromXmlFile() throws Exception {
    final DOI doi = new DOI("10.21373/example-full");

    DataCiteMetadata m =
        DataCiteValidator.fromXml(FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
    String xml = DataCiteValidator.toXml(doi, m);

    DataCiteMetadata m2 = DataCiteValidator.fromXml(xml);
    String xml2 = DataCiteValidator.toXml(doi, m2);

    assertEquals(m, m2);
    assertEquals(xml, xml2);
  }

  @Test
  public void testMetadataFromXmlAgainstFromBuilders() throws Exception {
    final DOI doi = new DOI("10.21373/example-full");

    final DataCiteMetadata metadataFromXml =
        DataCiteValidator.fromXml(FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
    final String metadataFromXmlResult = DataCiteValidator.toXml(doi, metadataFromXml);

    final DataCiteMetadata metadataFromBuilders =
        DataCiteMetadataTest.getMockMetadata(doi, "Full DataCite XML Example");
    final String metadataFromBuildersResult = DataCiteValidator.toXml(doi, metadataFromBuilders);

    assertEquals(metadataFromXml, metadataFromBuilders);
    assertEquals(metadataFromXmlResult, metadataFromBuildersResult);
  }

  @Test
  public void
      testValidateMetadataMandatoryFieldIdentifierIsAbsentShouldThrowInvalidMetadataException() {
    assertThrows(InvalidMetadataException.class, () -> DataCiteValidator.validateMetadata(
        FileUtils.classpathStream("metadata/minimal-v4-no-identifier.xml")));
  }

  @Test
  public void
      testValidateMetadataMandatoryFieldCreatorsIsAbsentShouldThrowInvalidMetadataException() {
    assertThrows(InvalidMetadataException.class, () -> DataCiteValidator.validateMetadata(
        FileUtils.classpathStream("metadata/minimal-v4-no-creators.xml")));
  }

  @Test
  public void
      testValidateMetadataMandatoryFieldPublisherIsAbsentShouldThrowInvalidMetadataException() {
    assertThrows(InvalidMetadataException.class, () -> DataCiteValidator.validateMetadata(
        FileUtils.classpathStream("metadata/minimal-v4-no-publisher.xml")));
  }

  @Test
  public void
      testValidateMetadataMandatoryFieldPublicationYearIsAbsentShouldThrowInvalidMetadataException() {
    assertThrows(InvalidMetadataException.class, () -> DataCiteValidator.validateMetadata(
        FileUtils.classpathStream("metadata/minimal-v4-no-publicationYear.xml")));
  }

  @Test
  public void
      testValidateMetadataMandatoryFieldResourceTypeIsAbsentShouldThrowInvalidMetadataException() {
    assertThrows(InvalidMetadataException.class, () -> DataCiteValidator.validateMetadata(
        FileUtils.classpathStream("metadata/minimal-v4-no-resourceType.xml")));
  }

  @Test
  public void testValidateMetadataMandatoryFieldTitlesIsAbsentShouldThrowInvalidMetadataException() {
    assertThrows(InvalidMetadataException.class, () -> DataCiteValidator.validateMetadata(
        FileUtils.classpathStream("metadata/minimal-v4-no-titles.xml")));
  }

  @Test
  public void testValidateMetadataNotSupportedFieldIsPresentShouldThrowInvalidMetadataException() {
    assertThrows(InvalidMetadataException.class, () -> DataCiteValidator.validateMetadata(
        FileUtils.classpathStream("metadata/minimal-v4-with-unsupported-field.xml")));
  }

  @Test
  public void testValidateMetadataIfWrongSourceShouldThrowIllegalStateException() {
    assertThrows(IllegalStateException.class,
        () -> DataCiteValidator.validateMetadata(FileUtils.classpathStream("wrong_path")));
  }

  /** Since javax.xml.validation.Validator is NOT thread-safe, make sure our usage of it is. */
  @Test
  public void testValidationMultiThread() throws InterruptedException, ExecutionException {
    int numberOfParallelTask = 50;

    List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
    for (int i = 0; i < numberOfParallelTask; i++) {
      Callable<Boolean> task =
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              boolean success = true;
              try {
                DataCiteValidator.validateMetadata(
                    FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
              } catch (InvalidMetadataException imEx) {
                imEx.printStackTrace();
                success = false;
              } catch (IOException ioEx) {
                success = false;
              }
              return success;
            }
          };
      tasks.add(task);
    }
    // use less Thread than the number of tasks
    ExecutorService executorService = Executors.newFixedThreadPool(numberOfParallelTask / 2);
    // call all threads and wait for completion
    List<Future<Boolean>> futures = executorService.invokeAll(tasks);

    // Validate
    assertEquals(futures.size(), numberOfParallelTask);
    for (Future<Boolean> future : futures) {
      assertTrue(future.get());
    }
  }
}
