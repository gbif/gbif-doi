package org.gbif.doi.api;

import org.gbif.metadata.eml.Eml;

import java.io.File;

public interface DoiService {

  /**
   * Reserves an identifier. The identifier status is set to RESERVED.
   * </br>
   * With DataCite, this is done by sending a POST request with the XML metadata (as the request body) to
   * https://mds.datacite.org/metadata. The DOI is specified inside the metadata.
   * </br>
   * With EZID, this is done by sending a PUT request to http://ezid.cdlib.org/id/{id} where {id} is a unique id
   * with shoulder/namespace prefix, and by setting the "_status" metadata element to "reserved".
   *
   * @param f   the XML file to write to
   * @param eml the EML object
   * @param doi the identifier to reserve
   * @param publisher the publishing organisation name
   * @param resourceType term describing what type of data set is described
   *
   * @throws DoiRegistrarException if the operation failed for any reason
   */
  void reserve(File f, Eml eml, String doi, String publisher, String resourceType) throws DoiRegistrarException;

  /**
   * Registers (makes public) an identifier that has been reserved, causing it to be registered with resolvers and
   * other external services.
   * </br>
   * With DataCite, this is done by sending a POST request with the  DOI and URL (as the request body) to
   * https://mds.datacite.org/doi.
   * </br>
   * With EZID, this can be done by updating the "_status" metadata element from "reserved" to "public".
   *
   * @param doi the identifier to make public
   *
   * @throws DoiRegistrarException if the operation failed for any reason
   */
  void makePublic(String doi) throws DoiRegistrarException;

  /**
   * Get the metadata for an identifier.
   * </br>
   * With DataCite, this is done by sending a GET request to https://mds.datacite.org/metadata.
   * </br>
   * With EZID, this is done by sending a GET request to http://ezid.cdlib.org/id/{id}.
   *
   * @param doi the identifier to get metadata for
   *
   * @throws DoiRegistrarException if the operation failed for any reason
   */
  void getMetadata(String doi) throws DoiRegistrarException;

  /**
   * Deletes an identifier that has only been reserved.
   * </br>
   * With DataCite, this is done by sending a DELETE request to https://mds.datacite.org/metadata, which inactivates
   * the DOI.
   * </br>
   * With EZID, this is done by sending a DELETE request to http://ezid.cdlib.org/id/{id}.
   *
   * @param doi the identifier to delete
   *
   * @throws DoiRegistrarException if the operation failed for any reason
   */
  void delete(String doi) throws DoiRegistrarException;

  /**
   * Makes a public identifier unavailable, causing the identifier to be removed from any external services. The
   * identifier is still public, but the object referenced by the identifier is not available any longer.
   * </p>
   * With DataCite, this is done by sending a DELETE request to https://mds.datacite.org/metadata, which inactivates
   * the DOI.
   * </br>
   * With EZID, this is done by setting the "_status" metadata element to "unavailable".
   *
   * @param doi the identifier to make unavailable
   *
   * @throws DoiRegistrarException if the operation failed for any reason
   */
  void makeUnavailable(String doi) throws DoiRegistrarException;

  /**
   * Makes an unavailable identifier public again, causing the identifier to be re-registered with external services.
   * The object referenced by the identifier becomes available again.
   * </br>
   * With DataCite, this is done by sending a POST request with XML metadata (as the request body) to
   * https://mds.datacite.org/metadata.
   * </br>
   * With EZID, this is done by switching the "_status" metadata element from "unavailable" to "public".
   *
   * @param doi the identifier to make available
   *
   * @throws DoiRegistrarException if the operation failed for any reason
   */
  void makeAvailable(String doi) throws DoiRegistrarException;

  /**
   * Updates the identifier metadata. This method must be called every time the object referenced by the identifier
   * changes (e.g. a gets republished, a data set is replaced by a new major version, etc).
   * </br>
   * With DataCite, this is done by sending a POST request with XML metadata (as the request body) to
   * https://mds.datacite.org/metadata.
   * </br>
   * With EZID, this is done by sending a POST request with metadata (as request body) to
   * http://ezid.cdlib.org/id/{id}.
   *
   * @param doi the identifier of metadata to update
   *
   * @throws DoiRegistrarException if the operation failed for any reason
   */
  void updateMetadata(String doi) throws DoiRegistrarException;
}