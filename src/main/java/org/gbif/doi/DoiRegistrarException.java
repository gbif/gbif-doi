package org.gbif.doi;

/**
 * Any exception happening during requests with agency APIs will be converted to this exception.
 */
public class DoiRegistrarException extends Exception {

  public DoiRegistrarException() {
  }

  public DoiRegistrarException(String message) {
    super(message);
  }

  public DoiRegistrarException(String message, Throwable cause) {
    super(message, cause);
  }

  public DoiRegistrarException(Throwable cause) {
    super(cause);
  }
}