package org.gbif.doi.service.datacite;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import okhttp3.ResponseBody;
import org.gbif.api.model.common.DOI;
import org.gbif.api.model.common.DoiData;
import org.gbif.datacite.rest.client.DataCiteClient;
import org.gbif.datacite.rest.client.configuration.ClientConfiguration;
import org.gbif.datacite.rest.client.retrofit.DataCiteRetrofitSyncClient;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.doi.service.DoiException;
import org.gbif.doi.service.DoiExistsException;
import org.gbif.doi.service.DoiHttpException;
import org.gbif.doi.service.DoiNotFoundException;
import org.gbif.doi.service.DoiService;
import org.gbif.utils.file.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import retrofit2.Response;

import java.io.InputStream;
import java.net.URI;

import static org.gbif.api.model.common.DoiStatus.NEW;
import static org.gbif.api.model.common.DoiStatus.REGISTERED;
import static org.gbif.api.model.common.DoiStatus.RESERVED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test DoiService and its implementation RestJsonApiDataCiteService.
 */
@RunWith(MockitoJUnitRunner.class)
public class DoiServiceIT {
  private final static URI TEST_TARGET = URI.create("http://www.gbif.org/datasets");
  private final static String PREFIX = "10.21373";
  private final static String SHOULDER = "gbif.";

  private static DoiService service;
  private static DoiService serviceWithMockClient;

  // for mocking exception cases (HTTP errors)
  private static DataCiteClient dataCiteClientMock;

  @BeforeClass
  public static void setup() throws Exception {
    try (InputStream dc = FileUtils.classpathStream("datacite.yaml")) {
      ObjectMapper mapper = new ObjectMapper(new YAMLFactory())
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

      final ClientConfiguration configuration = mapper.readValue(dc, ClientConfiguration.class);
      DataCiteClient dataCiteClient = new DataCiteRetrofitSyncClient(configuration);
      dataCiteClientMock = mock(DataCiteClient.class);

      service = new RestJsonApiDataCiteService(dataCiteClient);
      serviceWithMockClient = new RestJsonApiDataCiteService(dataCiteClientMock);
    }
  }

  private DOI newDoi() {
    return new DOI(PREFIX, SHOULDER + System.nanoTime());
  }

  @Test(expected = DoiHttpException.class)
  public void resolveOnHttpErrorExcept404ShouldThrowDoiHttpException() throws Exception {
    // given
    final DOI doi = newDoi();
    prepareExceptionThrown(doi, 400);

    // when
    serviceWithMockClient.resolve(doi);

    // then exception is expected
    verify(dataCiteClientMock).getDoi(doi.getDoiName());
  }

  @Test
  public void resolveOnNewNotFoundDoiShouldReturnStatusNew() throws DoiException {
    // given
    final DOI doi = newDoi();

    // when
    final DoiData actual = service.resolve(doi);

    // then
    assertEquals(new DoiData(NEW), actual);
  }

  @Test
  public void resolveOnDoiWhichWasReservedBeforeShouldReturnStatusReserved() throws DoiException {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "resolve test");
    service.reserve(doi, meta);

    // when
    final DoiData actual = service.resolve(doi);

    // then
    assertEquals(new DoiData(RESERVED), actual);
  }

  @Test
  public void resolveOnDoiWhichWasRegisteredBeforeShouldReturnStatusRegistered() throws DoiException {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "resolve test");
    service.register(doi, TEST_TARGET, meta);

    // when
    final DoiData actual = service.resolve(doi);

    // then
    assertEquals(new DoiData(REGISTERED, TEST_TARGET), actual);
  }

  @Test(expected = DoiExistsException.class)
  public void reservePerformedTwiceShouldThrowDoiExistsException() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");

    // when
    service.reserve(doi, meta);
    service.reserve(doi, meta);

    // then exception is expected
  }

  @Test
  public void deleteReservedDoiShouldBeOk() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);

    // when
    boolean isDeletedOne = service.delete(doi);

    // then
    assertTrue(isDeletedOne);
  }

  @Test(expected = DoiException.class)
  public void deleteRegisteredDoiShouldThrowDoiException() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "delete test");
    service.register(doi, TEST_TARGET, meta);

    // when
    service.delete(doi);

    // then exception is expected
  }

  @Test
  public void registerReservedShouldBeOk() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "register test");
    service.reserve(doi, meta);

    // when
    service.register(doi, TEST_TARGET, meta);

    // then
    assertEquals(new DoiData(REGISTERED, TEST_TARGET), service.resolve(doi));
  }

  @Test(expected = NullPointerException.class)
  public void registerWithoutUrlShouldThrowNPE() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "register test");

    // when
    service.register(doi, null, meta);

    // then exception is expected
  }

  @Test(expected = NullPointerException.class)
  public void registerWithoutMetaShouldThrowNPE() throws Exception {
    // given
    final DOI doi = newDoi();

    // when
    service.register(doi, TEST_TARGET, (DataCiteMetadata) null);

    // then exception is expected
  }

  @Test(expected = NullPointerException.class)
  public void registerWithoutIdentifierShouldThrowNPE() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "register test");

    // when
    service.register(null, TEST_TARGET, meta);

    // then exception is expected
  }

  @Test(expected = DoiNotFoundException.class)
  public void deleteNewDoiShouldThrowDoiNotFoundException() throws Exception {
    // given
    final DOI doi = newDoi();

    // when
    final boolean actual = service.delete(doi);

    // then
    assertFalse(actual);
  }

  @Test(expected = DoiNotFoundException.class)
  public void updateNewDoiWithNewUrlShouldThrowDoiNotFoundException() throws Exception {
    // given
    final DOI doi = newDoi();

    // when
    service.update(doi, TEST_TARGET);

    // then exception is expected
  }

  @Test(expected = DoiNotFoundException.class)
  public void updateNewDoiWithNewMetaShouldThrowDoiNotFoundException() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "update test");

    // when
    service.update(doi, meta);

    // then exception is expected
  }

  @Test
  public void updateReservedDoiShouldBeOk() throws Exception {
    // given
    final DOI doi1 = newDoi();
    final DOI doi2 = newDoi();
    DataCiteMetadata meta1 = DataCiteMetadataTest.testMetadata(doi1, "update test meta 1");
    DataCiteMetadata meta2 = DataCiteMetadataTest.testMetadata(doi1, "update test meta 2");
    service.reserve(doi1, meta1);
    service.reserve(doi2, meta2);
    final URI newUrl = TEST_TARGET.resolve("new");

    // when
    service.update(doi1, newUrl);
    service.update(doi2, meta2);

    // then
    assertEquals(new DoiData(RESERVED, newUrl), service.resolve(doi1));
    assertEquals(new DoiData(RESERVED), service.resolve(doi2));
  }

  @Test
  public void updateRegisteredDoiShouldBeOk() throws Exception {
    // given
    final DOI doi1 = newDoi();
    final DOI doi2 = newDoi();
    DataCiteMetadata meta1 = DataCiteMetadataTest.testMetadata(doi1, "update test meta 1");
    DataCiteMetadata meta2 = DataCiteMetadataTest.testMetadata(doi1, "update test meta 2");
    service.register(doi1, TEST_TARGET, meta1);
    service.register(doi2, TEST_TARGET, meta2);
    final URI newUrl = TEST_TARGET.resolve("new");

    // when
    service.update(doi1, newUrl);
    service.update(doi1, meta2);

    // then
    assertEquals(new DoiData(REGISTERED, newUrl), service.resolve(doi1));
    assertEquals(new DoiData(REGISTERED, TEST_TARGET), service.resolve(doi2));
  }

  @Test(expected = DoiExistsException.class)
  public void registerPerformedTwiceShouldThrowDoiExistsException() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "register test");

    // when
    service.register(doi, TEST_TARGET, meta);
    service.register(doi, TEST_TARGET, meta);

    // then exception is expected
  }

  @Test(expected = DoiHttpException.class)
  public void existsOnHttpErrorExcept404ShouldThrowDoiHttpException() throws Exception {
    // given
    final DOI doi = newDoi();
    prepareExceptionThrown(doi, 500);

    // when
    serviceWithMockClient.exists(doi);

    // then exception is expected
    verify(dataCiteClientMock).getDoi(doi.getDoiName());
  }

  @Test
  public void existsOnNotFoundShouldReturnFalse() throws Exception {
    // given
    final DOI doi = newDoi();
    prepareExceptionThrown(doi, 404);

    // when
    final boolean actual = serviceWithMockClient.exists(doi);

    // then
    verify(dataCiteClientMock).getDoi(doi.getDoiName());
    assertFalse(actual);
  }

  @Test
  public void existsOnNewDoiShouldReturnFalse() throws Exception {
    // given
    final DOI doi = newDoi();

    // when
    final boolean actual = service.exists(doi);

    // then
    assertFalse(actual);
  }

  @Test
  public void existsOnReservedDoiShouldReturnTrue() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "exists test");
    service.reserve(doi, meta);

    // when
    final boolean actual = service.exists(doi);

    // then
    assertTrue(actual);
  }

  @Test
  public void existsOnRegisteredShouldReturnTrue() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "exists test");
    service.register(doi, TEST_TARGET, meta);

    // when
    final boolean actual = service.exists(doi);

    // then
    assertTrue(actual);
  }

  @Test(expected = DoiHttpException.class)
  public void getMetadataOnHttpErrorShouldTrowDoiHttpException() throws Exception {
    // given
    final DOI doi = newDoi();
    prepareExceptionThrown(doi, 404);

    // when
    serviceWithMockClient.getMetadata(doi);

    // then exception is expected
    verify(dataCiteClientMock).getMetadata(doi.getDoiName());
  }

  @Test
  public void getMetadataShouldReturnValidXmlMetadata() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "getMetadata test");
    service.reserve(doi, meta);

    // when
    final String stringXmlMetadata = service.getMetadata(doi);

    // then
    assertEquals(doi.getDoiName(), DataCiteValidator.fromXml(stringXmlMetadata).getIdentifier().getValue().toLowerCase());
  }

  private void prepareExceptionThrown(DOI doi, int code) {
    when(dataCiteClientMock.getDoi(doi.getDoiName()))
        .thenReturn(Response.error(
            code,
            ResponseBody.create(okhttp3.MediaType.get("application/json"), "")));
    when(dataCiteClientMock.getMetadata(doi.getDoiName()))
        .thenReturn(Response.error(
            code,
            ResponseBody.create(okhttp3.MediaType.get("application/xml"), "")));
  }
}