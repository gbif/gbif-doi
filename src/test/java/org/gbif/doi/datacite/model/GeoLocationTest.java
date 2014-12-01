package org.gbif.doi.datacite.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeoLocationTest {
  public static final GeoLocation geoLocation =
    GeoLocation.builder().point(new LocationPoint(31.233, 67.302))
      .box(new LocationBox(new LocationPoint(42.893,-68.211), new LocationPoint(41.091,-71.032)))
      .description("Scandinavia").build();

  @Test
  public void testBuilder() {
    verifyGeoLocation(geoLocation);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the GeoLocation.
   */
  public static void verifyGeoLocation(GeoLocation geoLocation) {
    assertEquals("31.233 67.302", geoLocation.getPoint().toDataCiteFormat());
    assertEquals("41.091 -71.032 42.893 -68.211", geoLocation.getBox().toDataCiteFormat());
    assertEquals("Scandinavia", geoLocation.getDescription());
  }
}
