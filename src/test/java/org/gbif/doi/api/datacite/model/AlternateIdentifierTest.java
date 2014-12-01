package org.gbif.doi.api.datacite.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlternateIdentifierTest {

  public static final AlternateIdentifier alternateIdentifier =
    AlternateIdentifier.builder().identifier("8575f23e-f762-11e1-a439-00145eb45e9a")
      .type("GBIF Dataset UUID").build();

  @Test
  public void testBuilder() {
    verifyAlternateIdentifier(alternateIdentifier);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the AlternateIdentifier.
   */
  public static void verifyAlternateIdentifier(AlternateIdentifier identifier) {
    assertEquals("8575f23e-f762-11e1-a439-00145eb45e9a", identifier.getIdentifier());
    assertEquals("GBIF Dataset UUID", identifier.getType());
  }

}
