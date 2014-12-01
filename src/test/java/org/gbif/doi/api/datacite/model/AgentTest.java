package org.gbif.doi.api.datacite.model;

import org.gbif.doi.api.datacite.vocabulary.NameIdentifierScheme;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgentTest {

  public static final Agent agent =
    Agent.builder().name("Smith, John").identifier("http://orcid.org/0000-0002-1825-0097")
      .identifierScheme(NameIdentifierScheme.ORCID).appendAffiliation("BGBM").build();

  @Test
  public void testBuilder() {
    verifyAgent(agent);
  }

  /**
   * A utility to verify the provided object is populated with the static mock values for the Agent.
   */
  public static void verifyAgent(Agent agent) {
    assertEquals("Smith, John", agent.getName());
    assertEquals("http://orcid.org/0000-0002-1825-0097", agent.getIdentifier());
    assertEquals(NameIdentifierScheme.ORCID, agent.getIdentifierScheme());
    assertEquals("BGBM", agent.getAffiliations().get(0));
  }
}
