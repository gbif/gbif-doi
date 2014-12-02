package org.gbif.doi.datacite;

import org.gbif.api.vocabulary.Language;
import org.gbif.doi.services.DataciteValidator;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.Test;

public class BuilderTest {

  @Test
  public void testBuilder() throws Exception {
    Resource r = Resource.builder()
      .withResourceType(Resource.ResourceType.builder().withResourceTypeGeneral(ResourceType.DATASET).build())
      .withCreators()
        .addCreator().withCreatorName("Markus")
          .withNameIdentifier().withNameIdentifierScheme("ORCID").withSchemeURI("orcid.org").withValue("12445322").end()
        .end()
      .end()
      .withTitles()
        .addTitle().withValue("My Title").withLang(Language.GERMAN.getIso3LetterCode()).withTitleType(
        TitleType.TRANSLATED_TITLE).end()
      .end()
      .build();

    marshall(r);
  }

  private void marshall(Resource r) throws Exception {
    JAXBContext context = JAXBContext.newInstance(Resource.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    m.marshal(r, System.out);

    StringWriter writer = new StringWriter();
    m.marshal(r, writer);
    writer.close();

    DataciteValidator.validateMetadata(writer.toString());
  }

  @Test
  public void testObjectFactory() throws Exception {
    ObjectFactory of = new ObjectFactory();
    Resource res = of.createResource();

    Resource.Creators creators = of.createResourceCreators();
    Resource.Creators.Creator creator = of.createResourceCreatorsCreator();
    creator.setCreatorName("Piyapong");
    Resource.Creators.Creator.NameIdentifier nid = of.createResourceCreatorsCreatorNameIdentifier();
    nid.setValue("pc1405");
    creator.setNameIdentifier(nid);
    creators.getCreator().add(creator);
    res.setCreators(creators);

    Resource.Identifier id = of.createResourceIdentifier();
    id.setIdentifierType("DOI");
    id.setValue("10.5072/WDCC/CCSRNIES_SRES_B2");
    res.setIdentifier(id);

    Resource.Titles titles = of.createResourceTitles();
    Resource.Titles.Title title = of.createResourceTitlesTitle();
    title.setValue("National Institute for Environmental Studies and Center for Climate System Research Japan");
    titles.getTitle().add(title);
    res.setTitles(titles);

    res.setPublicationYear("2014");
    res.setPublisher("Piyapong");

    marshall(res);
  }

}