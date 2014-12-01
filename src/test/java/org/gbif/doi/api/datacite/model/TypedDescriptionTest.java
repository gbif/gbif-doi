package org.gbif.doi.api.datacite.model;

import org.gbif.doi.api.datacite.vocabulary.DescriptionType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypedDescriptionTest {

  public static final TypedDescription description =
    TypedDescription.builder().description("Short description").type(DescriptionType.ABSTRACT).build();

  @Test
  public void testBuilder() {
    verifyTypedDescription(description);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the TypedDescription.
   */
  public static void verifyTypedDescription(TypedDescription description) {
    assertEquals("Short description", description.getDescription());
    assertEquals(DescriptionType.ABSTRACT, description.getType());
  }
}
