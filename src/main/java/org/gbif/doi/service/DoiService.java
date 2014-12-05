package org.gbif.doi.service;

import org.gbif.api.model.common.DOI;
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
  DoiStatus resolve(DOI doi) throws DoiException;

  /**
   * Reserves a new identifier and defines its initial metadata.
   * Reserved ids are not known to resolvers yet and can still be fully deleted.
   *
   * @param metadata the metadata to be associated with the doi. The identifier inside the metadata will be overwritten
   *                 by the doi parameter given
   * @param doi the identifier to reserve
   *
   * @throws DoiExistsException if the DOI existed already regardless of its status
   * @throws DoiException if the operation failed for any reason
   */
  void reserve(DOI doi, DataCiteMetadata metadata) throws DoiExistsException, DoiException;

  /**
   * Mints a new random identifier with the given DOI prefix and reserves it.
   *
   * @param metadata the metadata to be associated with the doi. The identifier inside the metadata will be overwritten
   *                 by the generated DOI
   * @param prefix the identifier prefix to use to generate the random DOI
   * @param prefix the optional fixed beginning of the suffix to be prepended to the generated random suffix
   * @param length the length of the randomly generated suffix string. minimum 3, 5-10 is recommended.
   *
   * @throws DoiException if the operation failed for any reason
   */
  DOI reserveRandom(String prefix, String shoulder, int length, DataCiteMetadata metadata) throws DoiException;

  /**
   * Registers an identifier that has been reserved and assigns it a URL for resolution.
   * This causes the DOI to be publicly registered with resolvers and other external services.
   * DataCite and EZID restrict target URL domains and the target URL given MUST have a domain
   * matching your account permissions.
   *
   * You can also call this method to re-register previously deleted, registered DOIs
   * that are currently marked as inactive (DataCite) or unavailable (EZID).
   *
   * @param doi the identifier to register
   * @param target the URL the DOI should resolve to
   *
   * @throws DoiException if the operation failed for any reason
   * @throws DoiExistsException if the DOI was already registered
   */
  void register(DOI doi, URI target) throws DoiExistsException, DoiException;

  /**
   * Tries to delete an identifier. If the DOI has only been reserved it will be fully deleted,
   * if it was registered before it cannot be deleted as DOIs are permanent identifier.
   * In DataCite a DOI will be marked as "inactive" though, in EZID as "unavailable".
   * You can register an unavailable DOI again if needed.
   *
   * @param doi the identifier to delete
   * @return true if the DOI was fully deleted, false if it became unavailable
   *
   * @throws DoiException if the operation failed for any reason
   */
  boolean delete(DOI doi) throws DoiException;

  /**
   * Updates the identifier metadata. This method must be called every time the object or metadata referenced by
   * the identifier changes (e.g. a gets republished, a data set is replaced by a new major version, etc).
   *
   * @param doi the identifier of metadata to update
   *
   * @throws DoiException if the operation failed for any reason
   */
  void update(DOI doi, DataCiteMetadata metadata) throws DoiException;

  /**
   * Updates the registered identifiers target URL.
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