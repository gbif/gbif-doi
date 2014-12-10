package org.gbif.doi.service;

import org.gbif.api.model.common.DOI;

/**
 * Exception thrown if the used (datacite) metadata was not valid.
 * This can happen if required fields were omitted.
 */
public class InvalidMetadataException extends DoiException {
  private final DOI doi;

  public InvalidMetadataException(DOI doi, String message, Throwable e) {
    super(message, e);
    this.doi = doi;
  }

  public InvalidMetadataException(DOI doi, String message) {
    super(message);
    this.doi = doi;
  }

  public InvalidMetadataException(DOI doi, Throwable e) {
    super("Invalid metadata for " + doi, e);
    this.doi = doi;
  }

  public DOI getDoi() {
    return doi;
  }
}
