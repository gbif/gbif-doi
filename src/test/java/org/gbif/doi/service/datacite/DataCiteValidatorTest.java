package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.InvalidMetadataException;
import org.gbif.utils.file.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test DataCiteValidator.
 */
public class DataCiteValidatorTest {

  private static final String DATACITE_FULL_EXAMPLE_PATH = "metadata/datacite-example-full-v4.xml";
  private static final String DATACITE_MINIMAL_EXAMPLE_PATH = "metadata/minimal-v4.xml";

  @Test
  public void testValidateMetadataDataCiteMetadataExamplesShouldBeValid() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
    DataCiteValidator.validateMetadata(FileUtils.classpathStream(DATACITE_MINIMAL_EXAMPLE_PATH));
  }

  @Test
  public void testRoundTrip() throws Exception {
    final DOI doi = new DOI("10.21373/example-full");

    DataCiteMetadata m = DataCiteValidator.fromXml(FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
    String xml = DataCiteValidator.toXml(doi, m);

    DataCiteMetadata m2 = DataCiteValidator.fromXml(xml);
    String xml2 = DataCiteValidator.toXml(doi, m2);

    assertEquals(xml, xml2);
  }

  @Test(expected = InvalidMetadataException.class)
  public void testValidateMetadataMandatoryFieldIdentifierIsAbsentShouldThrowInvalidMetadataException() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal-v4-no-identifier.xml"));
  }

  @Test(expected = InvalidMetadataException.class)
  public void testValidateMetadataMandatoryFieldCreatorsIsAbsentShouldThrowInvalidMetadataException() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal-v4-no-creators.xml"));
  }

  @Test(expected = InvalidMetadataException.class)
  public void testValidateMetadataMandatoryFieldPublisherIsAbsentShouldThrowInvalidMetadataException() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal-v4-no-publisher.xml"));
  }

  @Test(expected = InvalidMetadataException.class)
  public void testValidateMetadataMandatoryFieldPublicationYearIsAbsentShouldThrowInvalidMetadataException() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal-v4-no-publicationYear.xml"));
  }

  @Test(expected = InvalidMetadataException.class)
  public void testValidateMetadataMandatoryFieldResourceTypeIsAbsentShouldThrowInvalidMetadataException() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal-v4-no-resourceType.xml"));
  }

  @Test(expected = InvalidMetadataException.class)
  public void testValidateMetadataMandatoryFieldTitlesIsAbsentShouldThrowInvalidMetadataException() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal-v4-no-titles.xml"));
  }

  @Test(expected = InvalidMetadataException.class)
  public void testValidateMetadataNotSupportedFieldIsPresentShouldThrowInvalidMetadataException() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal-v4-with-unsupported-field.xml"));
  }

  @Test(expected = IllegalStateException.class)
  public void testValidateMetadataIfWrongSourceShouldThrowIllegalStateException() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("wrong_path"));
  }

  /**
   * Since javax.xml.validation.Validator is NOT thread-safe, make sure our usage of it is.
   */
  @Test
  public void testValidationMultiThread() throws InterruptedException, ExecutionException {
    int numberOfParallelTask = 50;

    List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
    for (int i = 0; i < numberOfParallelTask; i++) {
      Callable<Boolean> task = new Callable<Boolean>() {
        @Override
        public Boolean call() {
          boolean success = true;
          try {
            DataCiteValidator.validateMetadata(FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
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