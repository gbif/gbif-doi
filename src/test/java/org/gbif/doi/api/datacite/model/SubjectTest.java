package org.gbif.doi.api.datacite.model;

import java.net.URISyntaxException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SubjectTest {

  public static Subject subject;

  static {
    try {
      subject = Subject.builder().subject("occurrence").scheme("GBIF Dataset Type Vocabulary")
        .schemeUri("http://rs.gbif.org/vocabulary/gbif/dataset_type.xml").build();
    } catch (URISyntaxException e) {
      fail("schemUri was not valid");
    }
  }

  @Test
  public void testBuilder() {
    verifySubject(subject);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the Subject.
   */
  public static void verifySubject(Subject subject) {
    assertEquals("occurrence", subject.getSubject());
    assertEquals("GBIF Dataset Type Vocabulary", subject.getScheme());
    assertEquals("http://rs.gbif.org/vocabulary/gbif/dataset_type.xml", subject.getSchemeUri().toString());
  }
}
