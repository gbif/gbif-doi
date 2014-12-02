package org.gbif.doi.datacite.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreatorTest {

  public static final Creator CREATOR =
    Creator.builder().name("Smith, John")
      .identifier(new NameIdentifier("http://orcid.org/0000-0002-1825-0097", "ORCID", "orcid.org"))
      .appendAffiliation("BGBM").build();

  @Test
  public void testBuilder() {
    verifyAgent(CREATOR);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the Agent.
   */
  public static void verifyAgent(Creator creator) {
    assertEquals("Smith, John", creator.getName());
    assertEquals("http://orcid.org/0000-0002-1825-0097", creator.getNameIdentifier().getNameIdentifier());
    assertEquals("ORCID", creator.getNameIdentifier().getNameIdentifierScheme());
    assertEquals("BGBM", creator.getAffiliations().get(0));
  }
}
