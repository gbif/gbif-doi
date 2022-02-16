/*
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
import org.gbif.api.model.common.DoiData;
import org.gbif.datacite.rest.client.DataCiteClient;
import org.gbif.datacite.rest.client.configuration.ClientConfiguration;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.doi.service.DoiException;
import org.gbif.doi.service.DoiExistsException;
import org.gbif.doi.service.DoiHttpException;
import org.gbif.doi.service.DoiNotFoundException;
import org.gbif.doi.service.DoiService;
import org.gbif.utils.file.FileUtils;

import java.io.InputStream;
import java.net.URI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.gbif.api.model.common.DoiStatus.FAILED;
import static org.gbif.api.model.common.DoiStatus.NEW;
import static org.gbif.api.model.common.DoiStatus.REGISTERED;
import static org.gbif.api.model.common.DoiStatus.RESERVED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/** Test DoiService and its implementation RestJsonApiDataCiteService. */
public class DoiServiceIT {
  private static final URI TEST_TARGET = URI.create("http://www.gbif.org/datasets");
  private static final String PREFIX = "10.21373";
  private static final String SHOULDER = "gbif.";

  private static DoiService service;
  private static DoiService serviceWithMockClient;

  // for mocking exception cases (HTTP errors)
  private static DataCiteClient dataCiteClientMock;

  @BeforeAll
  public static void setup() throws Exception {
    try (InputStream dc = FileUtils.classpathStream("datacite.yaml")) {
      ObjectMapper mapper =
          new ObjectMapper(new YAMLFactory())
              .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

      final ClientConfiguration configuration = mapper.readValue(dc, ClientConfiguration.class);
      dataCiteClientMock = mock(DataCiteClient.class);

      service =
          new RestJsonApiDataCiteService(
              configuration.getBaseApiUrl(), configuration.getUser(), configuration.getPassword());
      serviceWithMockClient = new RestJsonApiDataCiteService(dataCiteClientMock);
    }
  }

  private DOI newDoi() {
    return new DOI(PREFIX, SHOULDER + System.nanoTime());
  }

  @Test
  public void resolveOnHttpErrorExcept404ShouldThrowDoiHttpException() {
    // given
    final DOI doi = newDoi();
    prepareExceptionThrown(doi, 400);

    // when
    assertThrows(DoiHttpException.class, () -> serviceWithMockClient.resolve(doi));

    // then exception is expected
    verify(dataCiteClientMock).getDoi(doi.getDoiName());
  }

  @Test
  public void resolveOnNewNotFoundDoiShouldReturnStatusNew() throws Exception {
    // given
    final DOI doi = newDoi();

    // when
    final DoiData actual = service.resolve(doi);

    // then
    assertEquals(new DoiData(NEW), actual);
  }

  @Test
  public void
      resolveWhenServiceRespondedWithSuccessfulCodeButEmptyResponseShouldReturnStatusFailed()
          throws Exception {
    // given
    final DOI doi = newDoi();
    prepareSuccessfulResponseWithoutBody(doi);

    // when
    final DoiData actual = serviceWithMockClient.resolve(doi);

    // then
    assertEquals(new DoiData(FAILED), actual);
  }

  @Test
  public void resolveOnDoiWhichWasReservedBeforeShouldReturnStatusReserved() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "resolve test");
    service.reserve(doi, meta);

    // when
    final DoiData actual = service.resolve(doi);

    // then
    assertEquals(new DoiData(RESERVED), actual);
  }

  @Test
  public void resolveOnDoiWhichWasRegisteredBeforeShouldReturnStatusRegistered() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "resolve test");
    service.register(doi, TEST_TARGET, meta);

    // when
    final DoiData actual = service.resolve(doi);

    // then
    assertEquals(new DoiData(REGISTERED, TEST_TARGET), actual);
  }

  @Test
  public void reservePerformedTwiceShouldThrowDoiExistsException() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "reserve test");

    // when & then
    service.reserve(doi, meta);
    assertThrows(DoiExistsException.class, () -> service.reserve(doi, meta));
  }

  //  @Disabled("temporarily switched off because of DataCite Internal Server Error 500")
  @Test
  public void deleteReservedDoiShouldBeOk() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "reserve test");
    service.reserve(doi, meta);

    // when
    boolean isDeletedOne = service.delete(doi);

    // then
    assertTrue(isDeletedOne);
  }

  @Test
  public void deleteRegisteredDoiShouldThrowDoiException() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "delete test");
    service.register(doi, TEST_TARGET, meta);

    // when & then
    assertThrows(DoiException.class, () -> service.delete(doi));
  }

  @Test
  public void registerReservedShouldBeOk() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "register test");
    service.reserve(doi, meta);

    // when
    service.register(doi, TEST_TARGET, meta);

    // then
    assertEquals(new DoiData(REGISTERED, TEST_TARGET), service.resolve(doi));
  }

  @Test
  public void registerWithoutUrlShouldThrowNPE() {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "register test");

    // when & then
    assertThrows(NullPointerException.class, () -> service.register(doi, null, meta));
  }

  @Test
  public void registerWithoutMetaShouldThrowNPE() {
    // given
    final DOI doi = newDoi();

    // when & then
    assertThrows(
        NullPointerException.class,
        () -> service.register(doi, TEST_TARGET, (DataCiteMetadata) null));
  }

  @Test
  public void registerWithoutIdentifierShouldThrowNPE() {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "register test");

    // when & then
    assertThrows(NullPointerException.class, () -> service.register(null, TEST_TARGET, meta));
  }

  @Test
  public void deleteNewDoiShouldThrowDoiNotFoundException() {
    // given
    final DOI doi = newDoi();

    // when & then
    assertThrows(DoiNotFoundException.class, () -> service.delete(doi));
  }

  @Test
  public void updateNewDoiWithNewUrlShouldThrowDoiNotFoundException() {
    // given
    final DOI doi = newDoi();

    // when & then
    assertThrows(DoiNotFoundException.class, () -> service.update(doi, TEST_TARGET));
  }

  @Test
  public void updateNewDoiWithNewMetaShouldThrowDoiNotFoundException() {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "update test");

    // when & then
    assertThrows(DoiNotFoundException.class, () -> service.update(doi, meta));
  }

  @Test
  public void updateReservedDoiShouldBeOk() throws Exception {
    // given
    final DOI doi1 = newDoi();
    final DOI doi2 = newDoi();
    DataCiteMetadata meta1 = DataCiteMetadataTest.getMockMetadata(doi1, "update test meta 1");
    DataCiteMetadata meta2 = DataCiteMetadataTest.getMockMetadata(doi1, "update test meta 2");
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
    DataCiteMetadata meta1 = DataCiteMetadataTest.getMockMetadata(doi1, "update test meta 1");
    DataCiteMetadata meta2 = DataCiteMetadataTest.getMockMetadata(doi1, "update test meta 2");
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

  @Test
  public void registerPerformedTwiceShouldThrowDoiExistsException() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "register test");

    // when & then
    service.register(doi, TEST_TARGET, meta);
    assertThrows(DoiExistsException.class, () -> service.register(doi, TEST_TARGET, meta));
  }

  @Test
  public void existsOnHttpErrorExcept404ShouldThrowDoiHttpException() {
    // given
    final DOI doi = newDoi();
    prepareExceptionThrown(doi, 500);

    // when
    assertThrows(DoiHttpException.class, () -> serviceWithMockClient.exists(doi));

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
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "exists test");
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
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "exists test");
    service.register(doi, TEST_TARGET, meta);

    // when
    final boolean actual = service.exists(doi);

    // then
    assertTrue(actual);
  }

  @Test
  public void getMetadataOnHttpErrorShouldTrowDoiHttpException() {
    // given
    final DOI doi = newDoi();
    prepareExceptionThrown(doi, 404);

    // when
    assertThrows(DoiHttpException.class, () -> serviceWithMockClient.getMetadata(doi));

    // then exception is expected
    verify(dataCiteClientMock).getMetadata(doi.getDoiName());
  }

  @Test
  public void getMetadataShouldReturnValidXmlMetadata() throws Exception {
    // given
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.getMockMetadata(doi, "getMetadata test");
    service.reserve(doi, meta);

    // when
    final String stringXmlMetadata = service.getMetadata(doi);

    // then
    assertEquals(
        doi.getDoiName(),
        DataCiteValidator.fromXml(stringXmlMetadata).getIdentifier().getValue().toLowerCase());
  }

  private void prepareSuccessfulResponseWithoutBody(DOI doi) {
    when(dataCiteClientMock.getDoi(doi.getDoiName())).thenReturn(Response.success(null));
  }

  private void prepareExceptionThrown(DOI doi, int code) {
    when(dataCiteClientMock.getDoi(doi.getDoiName()))
        .thenReturn(
            Response.error(
                code, ResponseBody.create(okhttp3.MediaType.get("application/json"), "")));
    when(dataCiteClientMock.getMetadata(doi.getDoiName()))
        .thenReturn(
            Response.error(
                code, ResponseBody.create(okhttp3.MediaType.get("application/xml"), "")));
  }
}
