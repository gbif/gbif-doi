package org.gbif.doi.api.datacite.model;

import org.gbif.doi.api.datacite.vocabulary.ContributorType;
import org.gbif.doi.api.datacite.vocabulary.NameIdentifierScheme;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypedAgentTest {

  public static final TypedAgent typedAgent =
    (TypedAgent) TypedAgent.builder().type(ContributorType.DATA_MANAGER)
      .name("Thompson, Will").identifier("http://orcid.org/0000-0002-1825-0066")
      .identifierScheme(NameIdentifierScheme.ORCID).appendAffiliation("NHM").build();

  @Test
  public void testBuilder() {
    verifyTypedAgent(typedAgent);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the TypedAgent.
   */
  public static void verifyTypedAgent(TypedAgent agent) {
    assertEquals("Thompson, Will", agent.getName());
    assertEquals("http://orcid.org/0000-0002-1825-0066", agent.getIdentifier());
    assertEquals(NameIdentifierScheme.ORCID, agent.getIdentifierScheme());
    assertEquals(ContributorType.DATA_MANAGER, agent.getType());
    assertEquals("NHM", agent.getAffiliations().get(0));
  }
}
