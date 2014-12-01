package org.gbif.doi.api.datacite.model;

import org.gbif.doi.api.datacite.vocabulary.DateType;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypedDateTest {

  public static final TypedDate typedDate =
    TypedDate.builder().startDate(new Date(1300111111101l)).endDate(new Date(1322018752992l)).type(DateType.ACCEPTED)
      .build();

  @Test
  public void testBuilder() {
    verifyTypedDate(typedDate);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the TypedDate.
   */
  public static void verifyTypedDate(TypedDate typedDate) {
    assertEquals("2011-03-14", TypedDate.ISO_DATE_FORMAT.format(typedDate.getStartDate()));
    assertEquals("2011-11-23", TypedDate.ISO_DATE_FORMAT.format(typedDate.getEndDate()));
    assertEquals("2011-03-14/2011-11-23", typedDate.toRKMSString());
    assertEquals(DateType.ACCEPTED, typedDate.getType());
  }
}
