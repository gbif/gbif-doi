package org.gbif.doi;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;

import java.net.URI;
import javax.annotation.Nullable;

public interface DoiService {

  /**
   * Resolves the registered identifier to its URL.
   * @param doi the identifier to get metadata for
   * @return the URL the DOI is backed by or null if DOI does not exist or is only reserved
   *
   * @throws DoiException if the operation failed for any reason
   */
  @Nullable
  URI get(DOI doi) throws DoiException;

  /**
   * Reserves a new identifier. The identifier status is set to RESERVED.
   * </br>
   * With DataCite, this is done by sending a POST request with the XML metadata (as the request body) to
   * https://mds.xsd.datacite.org/metadata. The DOI is specified inside the metadata.
   * </br>
   * With EZID, this is done by sending a PUT request to http://ezid.cdlib.org/id/{id} where {id} is a unique id
   * with shoulder/namespace prefix, and by setting the "_status" metadata element to "reserved".
   *
   * @param metadata the metadata to be associated with the doi. The identifier inside the metadata will be overwritten
   *                 by the doi parameter given
   * @param doi the identifier to reserve
   *
   * @throws DoiException if the operation failed for any reason
   */
  void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException;

  /**
   * Mints a new random identifier with the given DOI prefix and reserves it.
   *
   * @param metadata the metadata to be associated with the doi. The identifier inside the metadata will be overwritten
   *                 by the generated DOI
   * @param prefix the identifier prefix to use to generate the random DOI
   * @param length the length of the randomly generated suffix string. minimum 3, 5-10 is recommended.
   *
   * @throws DoiException if the operation failed for any reason
   */
  DOI reserveRandom(String prefix, int length, DataCiteMetadata metadata) throws DoiException;

  /**
   * Registers an identifier that has been reserved and assigns it a URL for resolution.
   * This causes the DOI to be publicly registered with resolvers and other external services.
   * DataCite and EZID restrict target URL domains and the target URL given MUST have a domain
   * matching your account permissions.
   *
   * @param doi the identifier to register
   * @param target the URL the DOI should resolve to
   *
   * @throws DoiException if the operation failed for any reason
   */
  void register(DOI doi, URI target) throws DoiException;

  /**
   * Tries to delete an identifier. If the DOI has only been reserved it will be fully deleted,
   * if it was registered before it's status will become unavailable.
   * You can register an unavailable DOI again if needed.
   * </br>
   * With DataCite, this is done by sending a DELETE request to https://mds.xsd.datacite.org/metadata, which inactivates
   * the DOI.
   * </br>
   * With EZID, this is done by sending a DELETE request to http://ezid.cdlib.org/id/{id}
   * or by setting the "_status" metadata element to "unavailable" for registered DOIs.
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
   * </br>
   * With DataCite, this is done by sending a POST request with XML metadata (as the request body) to
   * https://mds.xsd.datacite.org/metadata.
   * </br>
   * With EZID, this is done by sending a POST request with metadata (as request body) to
   * http://ezid.cdlib.org/id/{id}.
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