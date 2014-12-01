package org.gbif.doi;

/**
 * Enumeration of all the different categories of errors we want to report on during metadata synchronisation.
 */
public enum ErrorCode {

  /**
   * Is any kind of error establishing a connection or during a connection that's usually on the network level
   * (connection refused, timeouts etc.).
   */
  IO_EXCEPTION,

  /**
   * Any kind of HTTP error (e.g. a non 200 response code).
   */
  HTTP_ERROR,

  /**
   * Anything that doesn't fit in the former categories (e.g. invalid URI).
   */
  OTHER_ERROR

}
