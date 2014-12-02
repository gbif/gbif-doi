package org.gbif.doi;

import org.gbif.api.model.common.DOI;

public class DoiExistsException extends DoiException {
  private final DOI doi;

  public DoiExistsException(DOI doi) {
    super("DOI " + doi + " exists already");
    this.doi = doi;
  }

  public DOI getDoi() {
    return doi;
  }
}
