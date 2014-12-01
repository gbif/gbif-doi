package org.gbif.doi.datacite.model;

import java.io.Serializable;

import com.google.common.base.Objects;

/**
 * Class representing a geographic location point in the DataCite metadata schema version 3.
 */
public class LocationPoint implements Serializable {
  public static final Double MAX_LONGITUDE = 180.0d;
  public static final Double MIN_LONGITUDE = -180.0d;
  public static final Double MAX_LATITUDE = 90.0d;
  public static final Double MIN_LATITUDE = -90.0d;
  // x (east/west), -180/180
  private Double longitude;
  // y (north/south), -90/90
  private Double latitude;

  public LocationPoint() {
  }

  public LocationPoint(LocationPoint p) {
    setLatitude(p.latitude);
    setLongitude(p.longitude);
  }

  public LocationPoint(Double latitude, Double longitude) {
    setLatitude(latitude);
    setLongitude(longitude);
  }

  public Double getLatitude() {
    return latitude == null ? null : latitude;
  }

  public Double getLongitude() {
    return longitude == null ? null : longitude;
  }

  public boolean isValid() {
    return latitude != null && longitude != null;
  }

  public void setLongitude(Double longitude) {
    if (longitude != null && (longitude < MIN_LONGITUDE || longitude > MAX_LONGITUDE)) {
      throw new IllegalArgumentException();
    }
    this.longitude = longitude == null ? null : longitude;
  }

  public void setLatitude(Double latitude) {
    if (latitude != null && (latitude < MIN_LATITUDE || latitude > MAX_LATITUDE)) {
      throw new IllegalArgumentException();
    }
    this.latitude = latitude == null ? null : latitude;
  }

  /**
   * @return formatted point as DataCite expects starting with latitude, then longitude with space in between
   */
  public String toDataCiteFormat() {
    return String.format("%s %s", latitude, longitude);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final LocationPoint other = (LocationPoint) obj;
    return Objects.equal(this.longitude, other.longitude) && Objects.equal(this.latitude, other.latitude);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(longitude, latitude);
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).
      add("longitude", longitude).
      add("latitude", latitude).
      toString();
  }
}
