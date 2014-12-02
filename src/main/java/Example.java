import org.gbif.datacite.kernel3.metadata.ObjectFactory;
import org.gbif.datacite.kernel3.metadata.Resource;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Example {

  public static void main(String[] args) {

    try {
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

      JAXBContext jaxbContext = JAXBContext.newInstance(Resource.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(res, System.out);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
