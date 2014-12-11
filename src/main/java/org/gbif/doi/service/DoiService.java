package org.gbif.doi.service;

import org.gbif.api.model.common.DOI;
import org.gbif.api.model.common.DoiData;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;

import java.net.URI;
import javax.annotation.Nullable;

public interface DoiService {

  /**
   * Resolves the registered identifier to its status and target URL.
   * @param doi the identifier to resolve
   * @return the status object with the target URL the DOI is backed by
   *         or null if DOI does not exist at all
   *
   * @throws DoiException if the operation failed for any reason
   */
  @Nullable
  DoiData resolve(DOI doi) throws DoiException;

  /**
   * Reserves a new identifier and defines its initial metadata.
   * Reserved ids are not known to resolvers yet and can still be fully deleted.
   *
   * @param doi the identifier to reserve
   * @param metadata the metadata to be associated with the doi given as a valid DataCite v3.1 XML document.
   *                 The identifier inside the metadata will be overwritten by the doi parameter given
   *
   * @throws DoiExistsException if the DOI existed already regardless of its status
   * @throws DoiException if the operation failed for any reason
   */
  void reserve(DOI doi, String metadata) throws DoiException;

  /**
   * Reserves a new identifier and defines its initial metadata.
   * Reserved ids are not known to resolvers yet and can still be fully deleted.
   *
   * @param doi the identifier to reserve
   * @param metadata the metadata to be associated with the doi. The identifier inside the metadata will be overwritten
   *                 by the doi parameter given
   *
   * @throws DoiExistsException if the DOI existed already regardless of its status
   * @throws DoiException if the operation failed for any reason
   */
  void reserve(DOI doi, DataCiteMetadata metadata) throws DoiExistsException, DoiException;

  /**
   * Registers an identifier that is either brand new, has been reserved or is currently marked as deleted.
   * It assigns the latest metadata and a URL for resolution.
   * This causes the DOI to be publicly registered with resolvers and other external services.
   * <br/>
   * DataCite and EZID restrict target URL domains and the target URL given MUST have a domain
   * matching your account permissions.
   * <br/>
   * You can also call this method to re-register previously deleted, registered DOIs
   * that are currently marked as inactive (DataCite) or unavailable (EZID). Because the API of these 2 implementations
   * differ in how to re-register deleted DOIs (DataCite requires new metadata, EZID needs a new terget URL),
   * we have to take both the metadata and the target URL as params.
   *
   * @param doi the identifier to register
   * @param target the URL the DOI should resolve to
   * @param metadata the metadata to be associated with the doi given as a valid DataCite v3.1 XML document.
   *                 The identifier inside the metadata will be overwritten by the explicitly given DOI
   *
   * @throws DoiException if the operation failed for any reason
   * @throws DoiExistsException if the DOI was already registered
   */
  void register(DOI doi, URI target, String metadata) throws DoiException;

  /**
   * Registers an identifier that is either brand new, has been reserved or is currently marked as deleted.
   * It assigns the latest metadata and a URL for resolution.
   * This causes the DOI to be publicly registered with resolvers and other external services.
   * <br/>
   * DataCite and EZID restrict target URL domains and the target URL given MUST have a domain
   * matching your account permissions.
   * <br/>
   * You can also call this method to re-register previously deleted, registered DOIs
   * that are currently marked as inactive (DataCite) or unavailable (EZID). Because the API of these 2 implementations
   * differ in how to re-register deleted DOIs (DataCite requires new metadata, EZID needs a new terget URL),
   * we have to take both the metadata and the target URL as params.
   *
   * @param doi the identifier to register
   * @param target the URL the DOI should resolve to
   * @param metadata the metadata to be associated with the doi. The identifier inside the metadata will be overwritten
   *                 by the explicitly given DOI
   *
   * @throws DoiException if the operation failed for any reason
   * @throws DoiExistsException if the DOI was already registered
   */
  void register(DOI doi, URI target, DataCiteMetadata metadata) throws DoiExistsException, DoiException;

  /**
   * Tries to delete an identifier. If the DOI has only been reserved it will be fully deleted,
   * if it was registered before it cannot be deleted as DOIs are permanent identifiers.
   * In DataCite a DOI will be marked as "inactive" though, in EZID as "unavailable".
   * You can re-register a deleted DOI again if needed.
   *
   * @param doi the identifier to delete
   * @return true if the reserved DOI was fully deleted, false if it was only marked as deleted
   *
   * @throws DoiException if the operation failed for any reason
   */
  boolean delete(DOI doi) throws DoiException;

  /**
   * Updates the identifier metadata. This method must be called every time the object or metadata referenced by
   * the identifier changes (e.g. a dataset gets republished, a dataset is replaced by a new major version, etc).
   *
   * @param doi the identifier of metadata to update
   * @param metadata the datacite metadata given as a valid DataCite v3.1 XML document
   *
   * @throws DoiException if the operation failed for any reason
   */
  void update(DOI doi, String metadata) throws DoiException;

  /**
   * Updates the identifier metadata. This method must be called every time the object or metadata referenced by
   * the identifier changes (e.g. a dataset gets republished, a dataset is replaced by a new major version, etc).
   *
   * @param doi the identifier of metadata to update
   * @param metadata the datacite metadata
   *
   * @throws DoiException if the operation failed for any reason
   */
  void update(DOI doi, DataCiteMetadata metadata) throws DoiException;

  /**
   * Updates the registered identifier's target URL.
   * DataCite and EZID restrict target URL domains and the target URL given MUST have a domain
   * matching your account permissions.
   *
   * @param doi the identifier of metadata to update
   * @param target the new URL the DOI should resolve to
   *
   * @throws DoiException if the operation failed for any reason
   */
  void update(DOI doi, URI target) throws DoiException;
}
