package org.gbif.doi.service.exception;

import org.gbif.api.model.common.DOI;

/**
 * Happening when trying to reserve or register an existing DOI.
 */
public class DoiExistsException extends DoiException {
  private final DOI doi;

  public DoiExistsException(Throwable cause, DOI doi) {
    super(cause);
    this.doi = doi;
  }

  public DoiExistsException(DOI doi) {
    this.doi = doi;
  }

  public DOI getDoi() {
    return doi;
  }
}