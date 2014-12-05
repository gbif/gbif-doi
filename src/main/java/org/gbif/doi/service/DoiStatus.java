package org.gbif.doi.service;

import java.net.URI;

import com.google.common.base.Objects;

/**
 * Simple status object for a DOI with a target URI and a status.
 */
public class DoiStatus {
  private final Status status;
  private final URI target;

  public DoiStatus(Status status, URI target) {
    this.status = status;
    this.target = target;
  }

  public DoiStatus(String ezidStatus, URI target) {
    this.status = Status.fromString(ezidStatus);
    this.target = target;
  }

  public Status getStatus() {
    return status;
  }

  public URI getTarget() {
    return target;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(status, target);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final DoiStatus other = (DoiStatus) obj;
    return Objects.equal(this.status, other.status) && Objects.equal(this.target, other.target);
  }

  @Override
  public String toString() {
    return "DoiStatus{" +
           "status=" + status +
           ", target=" + target +
           '}';
  }

  /**
   * This enumeration represents the status of a DOI identifier.
   * It represents both EZID and DataCite DOIs.
   */
  public enum Status {
    /**
     * The identifier is known only to the DOI registration agency.
     * This status may be used to reserve an identifier name without advertising the identifier's existence
     * to resolvers and other external services.
     * A reserved identifier may be fully deleted.
     */
    RESERVED("reserved"),

    /**
     * A public, registered DOI.
     * It's target URL is known to public resolvers and other external services.
     * It may be marked as DELETED in the future, but never again as RESERVED.
     */
    REGISTERED("public"),

    /**
     * The identifier once was registered, but the object referenced by the identifier is not available.
     * This is known as an "inactive" DOI in DataCite and "unavailable" in EZID.
     * <br/>
     * In EZID the identifier redirects to an EZID-provided "tombstone" page regardless of its target URL.
     * In DataCite the original target URL is still available.
     */
    DELETED("unavailable");

    private final String ezid;

    private Status(String ezid) {
      this.ezid = ezid;
    }

    /**
     * @return the identifier status value used in EZID.
     */
    public String getEzid() {
      return ezid;
    }

    /**
     * @return true if the identifier is registered
     */
    public boolean isRegistered() {
      return this != RESERVED;
    }

    public static Status fromString(String status) {
      for (Status s : Status.values()) {
        if (status.equalsIgnoreCase(s.name()) || status.equalsIgnoreCase(s.getEzid())) {
          return s;
        }
      }
      return null;
    }
  }

}
