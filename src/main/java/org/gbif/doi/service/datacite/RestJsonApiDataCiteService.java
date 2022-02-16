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
import org.gbif.api.model.common.DoiStatus;
import org.gbif.datacite.model.json.Datacite42Schema;
import org.gbif.datacite.rest.client.DataCiteClient;
import org.gbif.datacite.rest.client.configuration.ClientConfiguration;
import org.gbif.datacite.rest.client.model.DoiSimplifiedModel;
import org.gbif.datacite.rest.client.model.EventType;
import org.gbif.datacite.rest.client.retrofit.DataCiteRetrofitSyncClient;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.DoiException;
import org.gbif.doi.service.DoiExistsException;
import org.gbif.doi.service.DoiHttpException;
import org.gbif.doi.service.DoiNotFoundException;
import org.gbif.doi.service.DoiService;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jasminb.jsonapi.JSONAPIDocument;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.gbif.doi.service.datacite.DataCiteDoiStatusConstants.DRAFT;
import static org.gbif.doi.service.datacite.DataCiteDoiStatusConstants.FINDABLE;
import static org.gbif.doi.service.datacite.DataCiteDoiStatusConstants.REGISTERED;

/** DataCite service implementation with REST and JSON:API. */
public class RestJsonApiDataCiteService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(RestJsonApiDataCiteService.class);

  private DataCiteClient dataCiteClient;

  public RestJsonApiDataCiteService(DataCiteClient dataCiteClient) {
    this.dataCiteClient = dataCiteClient;
  }

  public RestJsonApiDataCiteService(String api, String user, String password) {
    ClientConfiguration cfg =
        ClientConfiguration.builder()
            .withBaseApiUrl(api)
            .withUser(user)
            .withPassword(password)
            .build();

    this.dataCiteClient = new DataCiteRetrofitSyncClient(cfg);
  }

  /**
   * Resolves the registered identifier to its status and target URL.
   *
   * @param doi the identifier to resolve
   * @return the status object with the target URL the DOI is backed by or null if DOI does not
   *     exist at all
   */
  @Nonnull
  @Override
  public DoiData resolve(DOI doi) throws DoiException {
    Objects.requireNonNull(doi);
    Response<JSONAPIDocument<Datacite42Schema>> doiResponse;

    doiResponse = dataCiteClient.getDoi(doi.getDoiName());
    throwExceptionOnBadResponseExcept404(doiResponse);

    if (doiResponse.code() == 404) {
      return new DoiData(DoiStatus.NEW);
    }

    JSONAPIDocument<Datacite42Schema> bodyJsonApiWrapper = doiResponse.body();

    if (!doiResponse.isSuccessful() || bodyJsonApiWrapper == null) {
      return new DoiData(DoiStatus.FAILED);
    }

    Datacite42Schema body = bodyJsonApiWrapper.get();
    String doiState = body.getState();

    if (DRAFT.equals(doiState)) {
      return new DoiData(
          DoiStatus.RESERVED, body.getUrl() != null ? URI.create(body.getUrl()) : null);
    }

    if (REGISTERED.equals(doiState)) {
      return new DoiData(DoiStatus.DELETED, URI.create(body.getUrl()));
    }

    if (FINDABLE.equals(doiState)) {
      return new DoiData(DoiStatus.REGISTERED, URI.create(body.getUrl()));
    }

    return new DoiData(DoiStatus.FAILED);
  }

  /**
   * Check if a DOI is reserved or registered.
   *
   * @param doi the identifier
   * @return exists DOI or not
   */
  @Override
  public boolean exists(DOI doi) throws DoiException {
    Objects.requireNonNull(doi);
    Response<JSONAPIDocument<Datacite42Schema>> doiResponse =
        dataCiteClient.getDoi(doi.getDoiName());
    throwExceptionOnBadResponseExcept404(doiResponse);

    return doiResponse.isSuccessful();
  }

  /**
   * Get metadata by doi.
   *
   * @param doi the identifier
   * @return xml metadata
   */
  @Override
  public String getMetadata(DOI doi) throws DoiException {
    Response<String> response = dataCiteClient.getMetadata(doi.getDoiName());
    throwExceptionOnBadResponse(response);
    return response.body();
  }

  /**
   * Reserve a doi. Uses createDoi method without the event type.
   *
   * @param doi the identifier
   * @param metadata the metadata to be associated with the doi
   */
  @Override
  public void reserve(DOI doi, String metadata) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be reserved with 'null' identifier");
    Objects.requireNonNull(metadata, "DOI can't be reserved with 'null' metadata");

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.REGISTERED || doiData.getStatus() == DoiStatus.RESERVED) {
      throw new DoiExistsException(
          "Can't reserve a DOI which is already registered/reserved " + doi.getDoiName(), doi);
    } else {
      DoiSimplifiedModel model = prepareDoiCreateModel(doi, metadata);
      JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
      throwExceptionOnBadResponse(dataCiteClient.createDoi(jsonApiWrapper));
    }
  }

  /**
   * Reserve a doi. Uses createDoi method without the event type.
   *
   * @param doi the identifier
   * @param metadata the metadata to be associated with the doi
   */
  @Override
  public void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be reserved with 'null' identifier");
    Objects.requireNonNull(metadata, "DOI can't be reserved with 'null' metadata");
    String xmlMetadata = DataCiteValidator.toXml(doi, metadata);
    reserve(doi, xmlMetadata);
  }

  /**
   * Register a doi. Uses createDoi method with the event type 'PUBLISH'.
   *
   * @param doi the identifier
   * @param metadata the metadata to be associated with the doi
   */
  @Override
  public void register(DOI doi, URI target, String metadata) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be registered without identifier");
    Objects.requireNonNull(target, "DOI can't be registered without target URL");
    Objects.requireNonNull(metadata, "DOI can't be registered without metadata");

    DoiSimplifiedModel model = prepareDoiCreateModel(doi, metadata);
    model.setEvent(EventType.PUBLISH.getValue());
    model.setUrl(target.toString());
    JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.REGISTERED) {
      throw new DoiExistsException(
          "Can't reserve a DOI which is already registered/reserved " + doi.getDoiName(), doi);
    } else if (doiData.getStatus() == DoiStatus.RESERVED) {
      throwExceptionOnBadResponse(dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper));
    } else {
      throwExceptionOnBadResponse(dataCiteClient.createDoi(jsonApiWrapper));
    }
  }

  /**
   * Register a doi. Uses createDoi method with the event type 'PUBLISH'.
   *
   * @param doi the identifier
   * @param metadata the metadata to be associated with the doi
   */
  @Override
  public void register(DOI doi, URI target, DataCiteMetadata metadata) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be registered without identifier");
    Objects.requireNonNull(target, "DOI can't be registered without target URL");
    Objects.requireNonNull(metadata, "DOI can't be registered without metadata");
    String xmlMetadata = DataCiteValidator.toXml(doi, metadata);
    register(doi, target, xmlMetadata);
  }

  /**
   * Creates DoiSimplifiedModel which can be passed as an argument to dataCiteClient's create
   * method.
   *
   * @param doi the identifier
   * @param metadata the metadata to be associated with the doi
   * @return doi model which can be registered or reserved
   */
  private DoiSimplifiedModel prepareDoiCreateModel(DOI doi, String metadata) {
    DoiSimplifiedModel model = new DoiSimplifiedModel();
    model.setDoi(doi.getDoiName());
    model.setXml(Base64.getEncoder().encodeToString(metadata.getBytes()));
    return model;
  }

  /**
   * Delete a doi.
   *
   * @param doi the identifier to delete
   * @return true if successfully deleted, false otherwise
   */
  @Override
  public boolean delete(DOI doi) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be deleted without identifier");

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.REGISTERED) {
      throw new DoiException("Registered DOI can't be deleted " + doi.getDoiName());
    } else if (doiData.getStatus() == DoiStatus.NEW) {
      throw new DoiNotFoundException("Can't delete non-existing DOI " + doi.getDoiName(), doi);
    }

    Response<Void> deleteResponse = dataCiteClient.deleteDoi(doi.getDoiName());
    throwExceptionOnBadResponse(deleteResponse);

    return deleteResponse.isSuccessful();
  }

  /**
   * Deactivate a doi.
   *
   * @param doi the identifier to deactivate
   */
  @Override
  public void deactivate(DOI doi) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be deactivated without identifier");

    DoiSimplifiedModel model = new DoiSimplifiedModel();
    model.setDoi(doi.getDoiName());
    model.setEvent(EventType.HIDE.getValue());
    JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
    throwExceptionOnBadResponse(dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper));
  }

  /**
   * Update with metadata.
   *
   * @param doi the identifier
   * @param metadata the DataCite metadata
   */
  @Override
  public void update(DOI doi, String metadata) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be updated with 'null' identifier");
    Objects.requireNonNull(metadata, "DOI can't be updated with 'null' metadata");

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.RESERVED || doiData.getStatus() == DoiStatus.REGISTERED) {
      DoiSimplifiedModel model = new DoiSimplifiedModel();
      model.setDoi(doi.getDoiName());
      model.setXml(Base64.getEncoder().encodeToString(metadata.getBytes()));
      JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
      throwExceptionOnBadResponse(dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper));
    } else {
      throw new DoiNotFoundException("Can't update non-existing DOI " + doi.getDoiName(), doi);
    }
  }

  /**
   * Update with metadata.
   *
   * @param doi the identifier
   * @param metadata the DataCite metadata
   * @throws DoiException if some problems occur while xml serializing
   */
  @Override
  public void update(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be updated with 'null' identifier");
    Objects.requireNonNull(metadata, "DOI can't be updated with 'null' metadata");
    String xmlMetadata = DataCiteValidator.toXml(doi, metadata);
    update(doi, xmlMetadata);
  }

  /**
   * Update with a new URL.
   *
   * @param doi the identifier of metadata to update
   * @param target the new URL the DOI should resolve to
   */
  @Override
  public void update(DOI doi, URI target) throws DoiException {
    Objects.requireNonNull(doi, "DOI can't be updated with 'null' identifier");
    Objects.requireNonNull(target, "DOI can't be updated with 'null' target URL");

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.RESERVED || doiData.getStatus() == DoiStatus.REGISTERED) {
      DoiSimplifiedModel model = new DoiSimplifiedModel();
      model.setDoi(doi.getDoiName());
      model.setUrl(target.toString());
      JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
      throwExceptionOnBadResponse(dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper));
    } else {
      throw new DoiNotFoundException(
          "Only a reserved/registered doi can be updated. DOI "
              + doi.getDoiName()
              + " status is "
              + doiData.getStatus(),
          doi);
    }
  }

  // check the response is unsuccessful and throw an exception
  private void throwExceptionOnBadResponse(Response response) throws DoiHttpException {
    if (!response.isSuccessful()) {
      throw new DoiHttpException(response.code(), response.message(), getErrorBody(response));
    }
  }

  // check the response is unsuccessful and throw an exception (except 404 status)
  private void throwExceptionOnBadResponseExcept404(Response response) throws DoiHttpException {
    if (!response.isSuccessful() && response.code() != 404) {
      throw new DoiHttpException(response.code(), response.message(), getErrorBody(response));
    }
  }

  private String getErrorBody(Response response) {
    String errorBody;
    try (final ResponseBody responseBody = response.errorBody()) {
      if (responseBody != null) {
        errorBody = responseBody.string();
      } else {
        LOG.warn("Can't read a response error body");
        errorBody = "{}";
      }
    } catch (IOException e) {
      LOG.warn("Can't read a response error body");
      errorBody = "{}";
    }
    return errorBody;
  }
}
