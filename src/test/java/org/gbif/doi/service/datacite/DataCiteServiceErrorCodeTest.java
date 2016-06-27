package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.api.model.common.DoiData;
import org.gbif.api.model.common.DoiStatus;
import org.gbif.doi.mock.MockHttpClient;
import org.gbif.doi.service.DoiHttpException;
import org.gbif.doi.service.ServiceConfig;
import org.gbif.utils.file.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 *
 * Test behavior of DataCiteService when the underlying HttpClient returns Error codes.
 *
 */
public class DataCiteServiceErrorCodeTest {

  public final static URI TEST_TARGET = URI.create("http://www.gbif.org/datasets");
  private File TEST_METADATA = FileUtils.getClasspathFile("metadata/minimal.xml");
  private DOI TEST_DOI = new DOI(DOI.TEST_PREFIX, "test");

  private int REQUEST_ENTITY_TOO_LARGE = 413;

  private DataCiteService buildDataCiteService(){
    try {
      ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
      InputStream dc = FileUtils.classpathStream("datacite.yaml");
      ServiceConfig cfg = mapper.readValue(dc, ServiceConfig.class);
      return new DataCiteService(new MockHttpClient(REQUEST_ENTITY_TOO_LARGE), cfg);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Test
  public void testRequestEntityTooLarge() throws Exception {

    boolean doiHttpExceptionCaught = false;
    DataCiteService service = buildDataCiteService();
    service = spy(service);

    // in order to test the HTTP code REQUEST_ENTITY_TOO_LARGE we need to mock the resolve(DOI) method.
    try {
      when(service.resolve(TEST_DOI)).thenReturn(new DoiData(DoiStatus.REGISTERED, TEST_TARGET));
      service.update(TEST_DOI, org.apache.commons.io.FileUtils.readFileToString(TEST_METADATA));
    }
    catch (DoiHttpException doiHttpEx){
      doiHttpExceptionCaught = true;
      assertEquals(REQUEST_ENTITY_TOO_LARGE, doiHttpEx.getStatus());
    }

    assertTrue("When HttpClient triggers a 413, DoiHttpException is thrown ", doiHttpExceptionCaught);
  }

}
