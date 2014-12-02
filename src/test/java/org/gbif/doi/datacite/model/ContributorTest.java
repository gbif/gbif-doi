package org.gbif.doi.datacite.model;

import org.gbif.doi.datacite.vocabulary.ContributorType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContributorTest {

  public static final Contributor contributer =
    (Contributor) Contributor.builder().type(ContributorType.DATA_MANAGER)
      .name("Thompson, Will")
      .identifier(new NameIdentifier("http://orcid.org/0000-0002-1825-0066", "ORCID", "orcid.org"))
      .appendAffiliation("NHM").build();

  @Test
  public void testBuilder() {
    verifyTypedAgent(contributer);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the TypedAgent.
   */
  public static void verifyTypedAgent(Contributor agent) {
    assertEquals("Thompson, Will", agent.getName());
    assertEquals("http://orcid.org/0000-0002-1825-0066", agent.getNameIdentifier().getNameIdentifier());
    assertEquals("ORCID", agent.getNameIdentifier().getNameIdentifierScheme());
    assertEquals(ContributorType.DATA_MANAGER, agent.getType());
    assertEquals("NHM", agent.getAffiliations().get(0));
  }
}
