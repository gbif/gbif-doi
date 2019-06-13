package org.gbif.doi.service.datacite;

import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.google.common.base.Preconditions;
import org.gbif.api.model.common.DOI;
import org.gbif.api.model.common.DoiData;
import org.gbif.api.model.common.DoiStatus;
import org.gbif.datacite.model.json.Datacite42Schema;
import org.gbif.datacite.rest.client.DataCiteClient;
import org.gbif.datacite.rest.client.model.DoiSimplifiedModel;
import org.gbif.datacite.rest.client.model.EventType;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.DoiException;
import org.gbif.doi.service.DoiExistsException;
import org.gbif.doi.service.DoiHttpException;
import org.gbif.doi.service.DoiNotFoundException;
import org.gbif.doi.service.DoiService;
import retrofit2.Response;

import javax.annotation.Nonnull;
import java.net.URI;
import java.util.Base64;

/**
 * DataCite service implementation with REST and JSON:API.
 */
public class RestJsonApiDataCiteService implements DoiService {

  private DataCiteClient dataCiteClient;

  public RestJsonApiDataCiteService(DataCiteClient dataCiteClient) {
    this.dataCiteClient = dataCiteClient;
  }

  /**
   * Resolves the registered identifier to its status and target URL.
   *
   * @param doi the identifier to resolve
   * @return the status object with the target URL the DOI is backed by or null if DOI does not exist at all
   */
  @Nonnull
  @Override
  public DoiData resolve(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);
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

    if ("draft".equals(doiState)) {
      return new DoiData(
          DoiStatus.RESERVED,
          body.getUrl() != null ? URI.create(body.getUrl()) : null
      );
    }

    if ("findable".equals(doiState)) {
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
    Preconditions.checkNotNull(doi);
    Response<JSONAPIDocument<Datacite42Schema>> doiResponse = dataCiteClient.getDoi(doi.getDoiName());
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
   * @param doi      the identifier
   * @param metadata the metadata to be associated with the doi
   */
  @Override
  public void reserve(DOI doi, String metadata) throws DoiException {
    Preconditions.checkNotNull(doi, "DOI can't be reserved with 'null' identifier");
    Preconditions.checkNotNull(metadata, "DOI can't be reserved with 'null' metadata");

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.REGISTERED || doiData.getStatus() == DoiStatus.RESERVED) {
      throw new DoiExistsException(doi);
    } else {
      DoiSimplifiedModel model = prepareDoiCreateModel(doi, metadata);
      JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
      throwExceptionOnBadResponse(dataCiteClient.createDoi(jsonApiWrapper));
    }
  }

  /**
   * Reserve a doi. Uses createDoi method without the event type.
   *
   * @param doi      the identifier
   * @param metadata the metadata to be associated with the doi
   */
  @Override
  public void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi, "DOI can't be reserved with 'null' identifier");
    Preconditions.checkNotNull(metadata, "DOI can't be reserved with 'null' metadata");
    String xmlMetadata = DataCiteValidator.toXml(doi, metadata);
    reserve(doi, xmlMetadata);
  }

  /**
   * Register a doi. Uses createDoi method with the event type 'PUBLISH'.
   *
   * @param doi      the identifier
   * @param metadata the metadata to be associated with the doi
   */
  @Override
  public void register(DOI doi, URI target, String metadata) throws DoiException {
    Preconditions.checkNotNull(doi, "DOI can't be registered without identifier");
    Preconditions.checkNotNull(target, "DOI can't be registered without target URL");
    Preconditions.checkNotNull(metadata, "DOI can't be registered without metadata");

    DoiSimplifiedModel model = prepareDoiCreateModel(doi, metadata);
    model.setEvent(EventType.PUBLISH.getValue());
    model.setUrl(target.toString());
    JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.REGISTERED) {
      throw new DoiExistsException(doi);
    } else if (doiData.getStatus() == DoiStatus.RESERVED) {
      throwExceptionOnBadResponse(dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper));
    } else {
      throwExceptionOnBadResponse(dataCiteClient.createDoi(jsonApiWrapper));
    }
  }

  /**
   * Register a doi. Uses createDoi method with the event type 'PUBLISH'.
   *
   * @param doi      the identifier
   * @param metadata the metadata to be associated with the doi
   */
  @Override
  public void register(DOI doi, URI target, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi, "DOI can't be registered without identifier");
    Preconditions.checkNotNull(target, "DOI can't be registered without target URL");
    Preconditions.checkNotNull(metadata, "DOI can't be registered without metadata");
    String xmlMetadata = DataCiteValidator.toXml(doi, metadata);
    register(doi, target, xmlMetadata);
  }

  /**
   * Creates DoiSimplifiedModel which can be passed as an argument to dataCiteClient's create method.
   *
   * @param doi      the identifier
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
    Preconditions.checkNotNull(doi, "DOI can't be deleted without identifier");

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.REGISTERED) {
      throw new DoiException("Registered DOI can't be deleted " + doi.getDoiName());
    } else if (doiData.getStatus() == DoiStatus.NEW) {
      throw new DoiNotFoundException(doi);
    }

    Response<Void> deleteResponse = dataCiteClient.deleteDoi(doi.getDoiName());
    throwExceptionOnBadResponse(deleteResponse);

    return deleteResponse.isSuccessful();
  }

  /**
   * Update with metadata.
   *
   * @param doi      the identifier
   * @param metadata the DataCite metadata
   */
  @Override
  public void update(DOI doi, String metadata) throws DoiException {
    Preconditions.checkNotNull(doi, "DOI can't be updated with 'null' identifier");
    Preconditions.checkNotNull(metadata, "DOI can't be updated with 'null' metadata");

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.RESERVED || doiData.getStatus() == DoiStatus.REGISTERED) {
      DoiSimplifiedModel model = new DoiSimplifiedModel();
      model.setDoi(doi.getDoiName());
      model.setXml(Base64.getEncoder().encodeToString(metadata.getBytes()));
      JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
      throwExceptionOnBadResponse(dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper));
    } else {
      throw new DoiNotFoundException(doi);
    }
  }

  /**
   * Update with metadata.
   *
   * @param doi      the identifier
   * @param metadata the DataCite metadata
   * @throws DoiException if some problems occur while xml serializing
   */
  @Override
  public void update(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi, "DOI can't be updated with 'null' identifier");
    Preconditions.checkNotNull(metadata, "DOI can't be updated with 'null' metadata");
    String xmlMetadata = DataCiteValidator.toXml(doi, metadata);
    update(doi, xmlMetadata);
  }

  /**
   * Update with a new URL.
   *
   * @param doi    the identifier of metadata to update
   * @param target the new URL the DOI should resolve to
   */
  @Override
  public void update(DOI doi, URI target) throws DoiException {
    Preconditions.checkNotNull(doi, "DOI can't be updated with 'null' identifier");
    Preconditions.checkNotNull(target, "DOI can't be updated with 'null' target URL");

    DoiData doiData = resolve(doi);

    if (doiData.getStatus() == DoiStatus.RESERVED || doiData.getStatus() == DoiStatus.REGISTERED) {
      DoiSimplifiedModel model = new DoiSimplifiedModel();
      model.setDoi(doi.getDoiName());
      model.setUrl(target.toString());
      JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
      throwExceptionOnBadResponse(dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper));
    } else {
      throw new DoiNotFoundException(doi);
    }
  }

  // check the response is unsuccessful and throw an exception
  private void throwExceptionOnBadResponse(Response response) throws DoiHttpException {
    if (!response.isSuccessful()) {
      throw new DoiHttpException(response.code(), response.message());
    }
  }

  // check the response is unsuccessful and throw an exception (except 404 status)
  private void throwExceptionOnBadResponseExcept404(Response response) throws DoiHttpException {
    if (!response.isSuccessful() && response.code() != 404) {
      throw new DoiHttpException(response.code(), response.message());
    }
  }
}
