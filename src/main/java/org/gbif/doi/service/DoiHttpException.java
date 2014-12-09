package org.gbif.doi.service;

public class DoiHttpException extends DoiException {
  private final int status;

  public DoiHttpException(int status) {
    super("HTTP "+ status);
    this.status = status;
  }

  public DoiHttpException(int status, String message) {
    super("HTTP "+ status + ": " + message);
    this.status = status;
  }

  public DoiHttpException(Throwable cause, int status) {
    super("HTTP "+ status, cause);
    this.status = status;
  }

  public int getStatus() {
    return status;
  }
}