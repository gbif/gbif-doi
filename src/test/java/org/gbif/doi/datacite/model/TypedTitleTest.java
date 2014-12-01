package org.gbif.doi.datacite.model;

import org.gbif.doi.datacite.vocabulary.TitleType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypedTitleTest {

  public static final TypedTitle title =
    TypedTitle.builder().title("BioBlitz Denmark").type(TitleType.ALTERNATIVE_TITLE).build();

  @Test
  public void testBuilder() {
    verifyTypedTitle(title);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the TypedTitle.
   */
  public static void verifyTypedTitle(TypedTitle title) {
    assertEquals("BioBlitz Denmark", title.getTitle());
    assertEquals(TitleType.ALTERNATIVE_TITLE, title.getType());
  }
}
