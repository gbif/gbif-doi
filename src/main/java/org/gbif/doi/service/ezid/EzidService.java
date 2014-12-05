package org.gbif.doi.service.ezid;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.BaseService;
import org.gbif.doi.service.DoiException;
import org.gbif.doi.service.DoiExistsException;
import org.gbif.doi.service.DoiHttpException;
import org.gbif.doi.service.DoiStatus;
import org.gbif.doi.service.ServiceConfig;

import java.net.URI;
import java.util.Map;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This EZID service implementation.
 * TODO: offer option to also register DOIs with CrossRef which is supported by the EZID API
 * http://ezid.cdlib.org/doc/apidoc.html
 */
public class EzidService extends BaseService {

  private static final Logger LOG = LoggerFactory.getLogger(EzidService.class);
  private static final URI DEFAULT_API = URI.create("https://ezid.cdlib.org/");
  private static final String NON_TARGET = "http://ezid.cdlib.org/id";
  private final URI apiWs;
  private final URI idWs;


  public EzidService(CloseableHttpClient httpClient, ServiceConfig cfg) {
    super(httpClient, cfg);
    apiWs = cfg.getApi() == null ? DEFAULT_API : cfg.getApi();
    idWs = apiWs.resolve("id/");
  }

  /**
   * This creates the EZID URI, and ensures that it is formatted correctly, e.g.
   * E.g. http://ezid.cdlib.org/id/doi:10.nnnn/suffix
   * Notice the DOI must start with the DOI access schema ("doi:") and uses an unescaped colon!
   *
   * @param doi identifier
   * @return EZID ID URI
   */
  @VisibleForTesting
  protected URI idUri(DOI doi) throws DoiException {
    try {
      return URI.create(idWs.toString() + doi);
    } catch (IllegalArgumentException e) {
      throw new DoiException("Unable to convert DOI to EZID URI", e);
    }
  }

  @Override
  public DoiStatus resolve(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);
    Map<String, String> meta = getANVL(doi);
    if (meta.containsKey(AnvlUtils.STATUS)) {
      URI target = null;
      String url = meta.get(AnvlUtils.TARGET);
      // avoid the default EZID target url
      if (url != null && !url.toLowerCase().startsWith(NON_TARGET)) {
        try {
          target = URI.create(meta.get(AnvlUtils.TARGET));
        } catch (IllegalArgumentException e) {
          LOG.debug("Invalid DOI URL", e.getMessage());
        }
      }
      return new DoiStatus(meta.get(AnvlUtils.STATUS), target);
    }
    return null;
  }

  private Map<String, String> getANVL(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);
    try {
      return AnvlUtils.read(get(idUri(doi)));

    } catch (DoiHttpException e) {
      if (Math.round( e.getStatus() / 100.0) == 4) {
        LOG.debug("Non existing DOI", e.getMessage());
        return Maps.newHashMap();
      }
      throw e;
    }
  }

  @Override
  public void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(metadata);
    Map<String, String> data = AnvlUtils.builder()
      .datacite(toXml(doi, metadata))
      .status(DoiStatus.Status.RESERVED)
      .build();
    postOrPut(doi, data, new HttpPut(idUri(doi)));
    LOG.info("Reserved {}", doi);
  }

  @Override
  public void register(DOI doi, URI target) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(target);

    DoiStatus status = resolve(doi);
    if (status != null && DoiStatus.Status.REGISTERED == status.getStatus()) {
      throw new DoiExistsException(doi);
    }
    Map<String, String> data = AnvlUtils.builder()
      .target(target)
      .status(DoiStatus.Status.REGISTERED)
      .build();
    postOrPut(doi, data, new HttpPost(idUri(doi)));
    LOG.info("Registered {}", doi);
  }

  @Override
  public boolean delete(DOI doi) throws DoiException {
    DoiStatus status = resolve(doi);
    if (status != null) {
      if (DoiStatus.Status.RESERVED == status.getStatus()) {
        delete(idUri(doi));
        LOG.info("Deleted {}", doi);
        return true;

      } else {
        // this is a registered DOI, we can only change the status to unavailable
        Map<String, String> data = AnvlUtils.builder()
          .target(null)
          .status(DoiStatus.Status.DELETED)
          .build();
        postOrPut(doi, data, new HttpPost(idUri(doi)));
        LOG.info("Made {} unavailable", doi);
        return false;
      }
    }
    throw new DoiException("DOI " + doi + " not existing");
  }

  @Override
  public void update(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(metadata);
    Map<String, String> data = AnvlUtils.builder()
      .datacite(toXml(doi, metadata))
      .build();
    postOrPut(doi, data, new HttpPost(idUri(doi)));
    LOG.info("Updated metadata for {}", doi);
  }

  @Override
  public void update(DOI doi, URI target) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(target);
    Map<String, String> data = AnvlUtils.builder()
      .target(target)
      .build();
    postOrPut(doi, data, new HttpPost(idUri(doi)));
    LOG.info("Updated metadata for {}", doi);
  }

  /**
   * Issues a post or put with the given EZID data map for a DOI.
   */
  protected void postOrPut(DOI doi, Map<String, String> anvl, HttpEntityEnclosingRequestBase req) throws DoiException {
    // body
    if (anvl != null && !anvl.isEmpty()) {
      HttpEntity entity = new StringEntity(AnvlUtils.write(anvl), PLAIN_TEXT_UTF8);
      req.setEntity(entity);
      authCall(req);
    }
  }
}
