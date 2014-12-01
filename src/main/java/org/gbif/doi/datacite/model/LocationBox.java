package org.gbif.doi.datacite.model;

import java.io.Serializable;

import com.google.common.base.Objects;

/**
 * Class representing a geographic location bounding box in the DataCite metadata schema version 3.
 * A bounding box has 2 points: P1 has maximum latitude and longitude, while p2 represents the minimum
 * ones, i.e. p1 is NorthEast, p2 is SouthWest.
 */
public class LocationBox implements Serializable {

  // x = east/west=longitude, -180/180
  // y = north/south = latitude, -90/90
  private LocationPoint max;

  private LocationPoint min;

  public static LocationBox newWorldInstance() {
    return new LocationBox(new LocationPoint(-90.0, -180.0), new LocationPoint(90.0, 180.0));
  }

  public LocationBox() {
    this(-90d, -180d, 90d, 180d);
  }

  public LocationBox(LocationPoint min, LocationPoint max) {
    this.min = new LocationPoint(min);
    this.max = new LocationPoint(max);
    setOrderedBounds(min.getLatitude(), min.getLongitude(), max.getLatitude(), max.getLongitude());
  }

  public LocationBox(Double minY, Double minX, Double maxY, Double maxX) {
    minY = minY == null ? -90 : minY;
    minX = minX == null ? -180 : minX;
    maxY = maxY == null ? 90 : maxY;
    maxX = maxX == null ? 180 : maxX;
    min = new LocationPoint(minY, minX);
    max = new LocationPoint(maxY, maxX);
    setOrderedBounds(minY, minX, maxY, maxX);
  }

  public LocationPoint getMax() {
    return max;
  }

  public LocationPoint getMin() {
    return min;
  }

  public boolean isValid() {
    return min != null && max != null && min.isValid() && max.isValid();
  }

  // Insure p1 is NE (max lat and long) and p2 is SW (min lat and long)
  public void setOrderedBounds(Double minY, Double minX, Double maxY, Double maxX) {
    setOrderedX(minX, maxX);
    setOrderedY(minY, maxY);
  }

  // Ensure that the greater of the x values goes in max and the lesser in min
  public void setOrderedX(Double x1, Double x2) {
    if (max == null) {
      max = new LocationPoint(x2, 0d);
    }
    if (min == null) {
      min = new LocationPoint(x1, 0d);
    }
    if (x1 > x2) {
      min.setLongitude(x2);
      max.setLongitude(x1);
    } else {
      min.setLongitude(x1);
      max.setLongitude(x2);
    }
  }

  // Insure that the greater of the y values goes in max and the lesser in min
  public void setOrderedY(Double y1, Double y2) {
    if (max == null) {
      max = new LocationPoint(0d, y2);
    }
    if (min == null) {
      min = new LocationPoint(0d, y1);
    }
    if (y1 > y2) {
      min.setLatitude(y2);
      max.setLatitude(y1);
    } else {
      min.setLatitude(y1);
      max.setLatitude(y2);
    }
  }

  /**
   * @return formatted box as DataCite expects starting with SW point (maxY maxX), then NE point (minY minX) with
   * original decimal length
   */
  public String toDataCiteFormat() {
    return String.format("%s %s %s %s", min.getLatitude(), min.getLongitude(), max.getLatitude(), max.getLongitude());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(max, min);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final LocationBox other = (LocationBox) obj;
    return Objects.equal(this.max, other.max) && Objects.equal(this.min, other.min);
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).
      add("max", max).
      add("min", min).
      toString();
  }
}
