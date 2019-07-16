package org.gbif.doi.service;

import org.gbif.api.model.common.DOI;

/**
 * Happening when trying to delete or update a non-existing DOI.
 */
public class DoiNotFoundException extends DoiException {
  private final DOI doi;

  public DoiNotFoundException(Throwable cause, DOI doi) {
    super(cause);
    this.doi = doi;
  }

  public DoiNotFoundException(String message, DOI doi) {
    super(message);
    this.doi = doi;
  }

  public DOI getDoi() {
    return doi;
  }
}
