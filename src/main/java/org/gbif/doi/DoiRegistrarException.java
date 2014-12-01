package org.gbif.doi;

/**
 * Any exception happening during requests with agency APIs will be converted to this exception.
 */
public class DoiRegistrarException extends Exception {

  private static final long serialVersionUID = -6777608958328542296L;
  private final ErrorCode errorCode;

  public DoiRegistrarException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public DoiRegistrarException(Throwable cause, ErrorCode errorCode) {
    super(cause);
    this.errorCode = errorCode;
  }

  public DoiRegistrarException(String message, Throwable cause, ErrorCode errorCode) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public DoiRegistrarException(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }

}
