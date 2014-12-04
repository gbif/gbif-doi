package org.gbif.doi;

import org.gbif.api.model.common.DOI;

/**
 * Exception thrown if the used (datacite) metadata was not valid.
 * This can happen if required fields were omitted.
 */
public class InvalidMetadataException extends DoiException {
  private final DOI doi;

  public InvalidMetadataException(DOI doi, Throwable sax) {
    super("Invalid metadata for " + doi, sax);
    this.doi = doi;
  }

  public DOI getDoi() {
    return doi;
  }
}
