package org.gbif.doi.services.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.DoiRegistrarException;
import org.gbif.doi.DoiService;
import org.gbif.doi.ErrorCode;
import org.gbif.doi.datacite.DataCiteMetadataV3;
import org.gbif.doi.services.BaseService;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.common.base.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ByteArrayEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This DataCite service implementation.
 */
public class DataciteService extends BaseService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(DataciteService.class);
  private static final String METADATA_ENDPOINT_URI = "https://mds.xsd.datacite.org/metadata";
  private final Unmarshaller deserilizer;
  private final Marshaller serilizer;

  public DataciteService(HttpClient httpClient, String username, String password) {
    super(httpClient, username, password);
    try {
      JAXBContext context = JAXBContext.newInstance( org.gbif.doi.datacite.DataCiteMetadataV3.class );
      deserilizer = context.createUnmarshaller();
      serilizer = context.createMarshaller();
      serilizer.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

    } catch (JAXBException e) {
      throw new IllegalStateException("Fail to setup JAXB", e);
    }
  }

  @Override
  public void reserve(DOI doi, DataCiteMetadataV3 metadata, String publisher, String resourceType) throws DoiRegistrarException {
    LOG.info("Reserving identifier: {}", doi);
    try {
      // metadata as body
      StringWriter writer = new StringWriter();
      serilizer.marshal(metadata, writer);
      writer.close();
      HttpEntity entity = new ByteArrayEntity(writer.toString().getBytes(Charsets.UTF_8));
      postXml(new URI(METADATA_ENDPOINT_URI), entity);

    } catch (IOException e) {
      throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
    } catch (JAXBException e) {
      throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
    } catch (URISyntaxException e) {
      throw new DoiRegistrarException(e, ErrorCode.HTTP_ERROR);
    } catch (Exception e) {
      throw new DoiRegistrarException(e, ErrorCode.OTHER_ERROR);
    }
  }

  @Override
  public void makePublic(DOI doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public DataCiteMetadataV3 getMetadata(DOI doi) throws DoiRegistrarException {
    // TODO
    return null;
  }

  @Override
  public void delete(DOI doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void makeUnavailable(DOI doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void makeAvailable(DOI doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void updateMetadata(DOI doi, DataCiteMetadataV3 metadata) throws DoiRegistrarException {
    // TODO
  }
}
