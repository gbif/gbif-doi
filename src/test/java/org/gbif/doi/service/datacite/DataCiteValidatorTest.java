package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.doi.service.exception.InvalidMetadataException;
import org.gbif.utils.file.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataCiteValidatorTest {

  private static final String DATACITE_FULL_EXAMPLE_PATH = "metadata/datacite-example-full-v4.xml";

  @Test
  public void testValidateMetadata() throws Exception {
    DataCiteValidator.validateMetadata(FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
    DataCiteValidator.validateMetadata(FileUtils.classpathStream("metadata/minimal-v4.xml"));
  }

  @Test
  public void testValidateMetadataBean() throws Exception {
    final DOI doi = new DOI("10.1234/gbif");
    DataCiteValidator.validateMetadata(DataCiteValidator.toXml(doi, DataCiteMetadataTest.testMetadata()));
  }

  @Test
  public void testRoundtrip() throws Exception {
    final DOI doi = new DOI("10.1234/gbif");

    DataCiteMetadata m = DataCiteValidator.fromXml(FileUtils.classpathStream(DATACITE_FULL_EXAMPLE_PATH));
    String xml = DataCiteValidator.toXml(doi, m);

    DataCiteMetadata m2 = DataCiteValidator.fromXml(xml);
    String xml2 = DataCiteValidator.toXml(doi, m2);

    assertEquals(xml, xml2);
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
    Assert.assertEquals(futures.size(), numberOfParallelTask);
    for (Future<Boolean> future : futures) {
      Assert.assertTrue(future.get());
    }
  }
}