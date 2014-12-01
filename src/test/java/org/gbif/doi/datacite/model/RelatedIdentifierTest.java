package org.gbif.doi.datacite.model;


import org.gbif.doi.datacite.vocabulary.RelatedIdentifierType;
import org.gbif.doi.datacite.vocabulary.RelationType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RelatedIdentifierTest {

  public static final RelatedIdentifier relatedIdentifier =
    RelatedIdentifier.builder().identifier("doi:10.1430/8111").type(RelatedIdentifierType.DOI)
      .relationType(RelationType.IS_METADATA_FOR).metadataScheme("GBIF Metadata Profile")
      .schemeUri("http://rs.gbif.org/schema/eml-gbif-profile/1.0.2/eml.xsd").schemeType("XSD").build();

  @Test
  public void testBuilder() {
    verifyRelatedIdentifier(relatedIdentifier);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the RelatedIdentifier.
   */
  public static void verifyRelatedIdentifier(RelatedIdentifier identifier) {
    assertEquals("doi:10.1430/8111", identifier.getIdentifier());
    assertEquals(RelatedIdentifierType.DOI, identifier.getType());
    assertEquals(RelationType.IS_METADATA_FOR, identifier.getRelationType());
    assertEquals("GBIF Metadata Profile", identifier.getMetadataScheme());
    assertEquals("http://rs.gbif.org/schema/eml-gbif-profile/1.0.2/eml.xsd", identifier.getSchemeUri());
    assertEquals("XSD", identifier.getSchemeType());
  }

}
