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
import org.gbif.doi.service.DoiService;
import retrofit2.Response;

import javax.annotation.Nullable;
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
    @Nullable
    @Override
    public DoiData resolve(DOI doi) {
        Preconditions.checkNotNull(doi);
        Response<JSONAPIDocument<Datacite42Schema>> doiResponse;

        try {
            doiResponse = dataCiteClient.getDoi(doi.getDoiName());
        } catch (Exception e) {
            return new DoiData(DoiStatus.FAILED);
        }
        JSONAPIDocument<Datacite42Schema> bodyJsonApiWrapper = doiResponse.body();

        if (!doiResponse.isSuccessful() || bodyJsonApiWrapper == null) {
            return new DoiData(DoiStatus.FAILED);
        }

        Datacite42Schema body = bodyJsonApiWrapper.get();
        String doiState = body.getState();

        if ("draft".equals(doiState)) {
            return new DoiData(DoiStatus.RESERVED);
        }

        if ("findable".equals(doiState)) {
            return new DoiData(DoiStatus.REGISTERED);
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
    public boolean exists(DOI doi) {
        Preconditions.checkNotNull(doi);
        Response<JSONAPIDocument<Datacite42Schema>> doiResponse;
        try {
            doiResponse = dataCiteClient.getDoi(doi.getDoiName());
        } catch (Exception e) {
            return false;
        }

        return doiResponse.isSuccessful();
    }

    /**
     * Get metadata by doi.
     *
     * @param doi the identifier
     * @return xml metadata
     */
    @Override
    public String getMetadata(DOI doi) {
        Response<JSONAPIDocument<Datacite42Schema>> response = dataCiteClient.getDoi(doi.getDoiName());
        String encodedXmlMetadata = response.body().get().getXml();
        return new String(Base64.getDecoder().decode(encodedXmlMetadata));
    }

    /**
     * Reserve a doi. Uses createDoi method without the event type.
     *
     * @param doi      the identifier
     * @param metadata the metadata to be associated with the doi
     */
    @Override
    public void reserve(DOI doi, String metadata) {
        Preconditions.checkNotNull(doi);
        Preconditions.checkNotNull(metadata);
        DoiSimplifiedModel model = prepareDoiCreateModel(doi, metadata);
        JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
        dataCiteClient.createDoi(jsonApiWrapper);
    }

    /**
     * Reserve a doi. Uses createDoi method without the event type.
     *
     * @param doi      the identifier
     * @param metadata the metadata to be associated with the doi
     */
    @Override
    public void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException {
        Preconditions.checkNotNull(doi);
        Preconditions.checkNotNull(metadata);
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
    public void register(DOI doi, URI target, String metadata) {
        Preconditions.checkNotNull(doi);
        Preconditions.checkNotNull(metadata);

        DoiSimplifiedModel model = prepareDoiCreateModel(doi, metadata);
        model.setEvent(EventType.PUBLISH.getValue());
        model.setUrl(target.toString());
        JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);

        if (exists(doi)) {
            dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper);
        } else {
            dataCiteClient.createDoi(jsonApiWrapper);
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
        Preconditions.checkNotNull(doi);
        Preconditions.checkNotNull(metadata);
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
    public boolean delete(DOI doi) {
        Preconditions.checkNotNull(doi);
        Response<Void> deleteResponse = dataCiteClient.deleteDoi(doi.getDoiName());
        return deleteResponse.isSuccessful();
    }

    /**
     * Update with metadata.
     *
     * @param doi      the identifier
     * @param metadata the datacite metadata
     */
    @Override
    public void update(DOI doi, String metadata) {
        Preconditions.checkNotNull(doi);
        Preconditions.checkNotNull(metadata);
        DoiSimplifiedModel model = new DoiSimplifiedModel();
        model.setDoi(doi.getDoiName());
        model.setXml(Base64.getEncoder().encodeToString(metadata.getBytes()));
        JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
        dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper);
    }

    /**
     * Update with metadata.
     *
     * @param doi      the identifier
     * @param metadata the datacite metadata
     * @throws DoiException if some problems occur while xml serializing
     */
    @Override
    public void update(DOI doi, DataCiteMetadata metadata) throws DoiException {
        Preconditions.checkNotNull(doi);
        Preconditions.checkNotNull(metadata);
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
    public void update(DOI doi, URI target) {
        Preconditions.checkNotNull(doi);
        Preconditions.checkNotNull(target);
        DoiSimplifiedModel model = new DoiSimplifiedModel();
        model.setDoi(doi.getDoiName());
        model.setUrl(target.toString());
        JSONAPIDocument<DoiSimplifiedModel> jsonApiWrapper = new JSONAPIDocument<>(model);
        dataCiteClient.updateDoi(doi.getDoiName(), jsonApiWrapper);
    }
}
