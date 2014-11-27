package org.gbif.doi.services.ezid;

/**
 * This enumeration represents the status of an EZID identifier. The status is recorded as the value of the "_status"
 * EZID metadata element.
 */
public enum IdentifierStatus {
  /**
   * A reserved identifier is only known to EZID. It may be specified only at identifier creation time.
   */
  RESERVED,
  /**
   * A public identifier will be registered with resolvers and other external services. It may be marked as unavailable.
   */
  PUBLIC,
  /**
   * An unavailable identifier is public, but the object referenced by the identifier is not available with an optional
   * message explaining why following the status. The identifier redirects to an EZID-provied tombstone page regardless
   * of its target URL. An unavailable identifier will be removed from any external services. It may be returned to
   * public status.
   */
  UNAVAILABLE

}
