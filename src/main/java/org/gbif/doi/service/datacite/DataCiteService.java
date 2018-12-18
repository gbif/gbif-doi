package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.api.model.common.DoiData;
import org.gbif.api.model.common.DoiStatus;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.BaseService;
import org.gbif.doi.service.DoiException;
import org.gbif.doi.service.DoiExistsException;
import org.gbif.doi.service.DoiHttpException;
import org.gbif.doi.service.ServiceConfig;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This DataCite service implementation.
 * https://mds.datacite.org/static/apidoc
 */
public class DataCiteService extends BaseService {

  private static final Logger LOG = LoggerFactory.getLogger(DataCiteService.class);
  private static final ContentType APPLICATION_XML_UTF8 = ContentType.create("application/xml", Charsets.UTF_8);
  private static final ContentType APPLICATION_JSON_UTF8 = ContentType.create("application/vnd.api+json", Charsets.UTF_8);
  private static final URI DEFAULT_API = URI.create("https://mds.datacite.org/");
  // god knows why, but datacite assigns this URI to all reserved test DOIs as target URLs
  private static final URI TEST_404_TARGET = URI.create("http://www.datacite.org/testprefix");
  private final URI doiWs;
  private final URI metadataWs;
  private final String restApiWs;
  private final ServiceConfig cfg;

  public DataCiteService(CloseableHttpClient httpClient, ServiceConfig cfg) {
    super(httpClient, cfg);
    this.cfg = cfg;
    URI apiWs = cfg.getApi() == null ? DEFAULT_API : cfg.getApi();
    doiWs = apiWs.resolve("/doi/");
    metadataWs = apiWs.resolve("/metadata/");
    restApiWs = DEFAULT_API.toString().contains("test") ? "https://api.test.datacite.org/dois/" : "https://api.datacite.org/dois/";
  }

  /**
   * Detecting the status might need 2 calls.
   * A reserved DOI returns metadata and either the test or NULL target URL.
   * An active registered DOI returns metadata and a target URI
   * A deleted but registered DOI returns a http 410 for the metadata and still the target URI.
   */
  @Override
  public DoiData resolve(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);
    try {

      final URI target = getTargetUrl(doi);
      try {

        String metadata = get(metadataUri(doi));
        metadata = metadata != null ? metadata.trim() : "";
        if (metadata.isEmpty()) {
          return new DoiData(DoiStatus.DELETED, target);
        }

        return target == null ? new DoiData(DoiStatus.RESERVED, null) : new DoiData(DoiStatus.REGISTERED, target);

      } catch (DoiHttpException e) {
        // we only see a 410 for the metadata when a registered DOI was deleted
        if (e.getStatus() == 410) {
          return new DoiData(DoiStatus.DELETED, target);
        }
      }

    } catch (DoiException e) {
      LOG.debug("Unknown error detecting DOI status", e.getMessage());
    }
    return null;
  }

  @Override
  public String getMetadata(DOI doi) throws DoiException {
    return get(metadataUri(doi));
  }

  private URI getTargetUrl(DOI doi) throws DoiHttpException {
    // get target URI
    String content = null;
    try {
      content = get(doiUri(doi));
      if (!Strings.isNullOrEmpty(content)) {
        URI target = URI.create(content);
        if (!TEST_404_TARGET.equals(target)) {
          return target;
        }
      }
    } catch (IllegalArgumentException e) {
      LOG.debug("DataCite returned an invalid target URL {}", content, e.getMessage());
    } catch (DoiHttpException e) {
      if (Math.round( e.getStatus() / 100.0) == 4) {
        throw e;
      }
      LOG.debug("Non existing DOI", e.getMessage());
    } catch (DoiException e) {
      LOG.debug("Non existing DOI", e.getMessage());
    }
    return null;
  }

  /**
   *
   * @return true if the DOI is reserved or registered
   */
  public boolean exists(DOI doi) throws DoiException {
    try {
      get(metadataUri(doi));
    } catch (DoiHttpException e) {
      //probably not a good idea to swallow exceptions like 401 and 403
      return false;
    }
    return true;
  }

  @Override
  public void reserve(DOI doi, String metadata) throws DoiException {
    DataCiteValidator.validateMetadata(metadata);
    reserveWithoutValidation(doi, metadata);
  }

  @Override
  public void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException {
    reserveWithoutValidation(doi, DataCiteValidator.toXml(doi, metadata));
  }

  private void reserveWithoutValidation(DOI doi, String metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(metadata);
    if (exists(doi)) {
      throw new DoiExistsException(doi);
    }
    post(doi, metadataWs, metadata);
    LOG.info("Reserved {}", doi);
  }

  @Override
  public void register(DOI doi, URI target, String metadata) throws DoiException {
    DataCiteValidator.validateMetadata(metadata);
    registerWithoutValidation(doi, target, metadata);
  }

  @Override
  public void register(DOI doi, URI target, DataCiteMetadata metadata) throws DoiException {
    registerWithoutValidation(doi, target, DataCiteValidator.toXml(doi, metadata));
  }

  private void registerWithoutValidation(DOI doi, URI target, String metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(target);
    Preconditions.checkNotNull(metadata);
    DoiData status = resolve(doi);
    if (status != null && DoiStatus.REGISTERED == status.getStatus()) {
      throw new DoiExistsException(doi);
    }
    // POST metadata first
    post(doi, metadataWs, metadata);
    // POST the DOI after
    authCall(buildDoiUrlPost(doi, target));
    if (status != null && DoiStatus.DELETED == status.getStatus()) {
      LOG.info("Re-registered {}", doi);
    } else {
      LOG.info("Registered {}", doi);
    }
  }

  @Override
  public boolean delete(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);

    URI url = getTargetUrl(doi);
    if (url == null) {
      delete(doiUri(doi));
    } else {
      deleteMetadata(doi);
    }

    LOG.info("Deleted {}", doi);
    return resolve(doi) == null;
  }

  // WORKAROUND, DIRTY TRICK HOW TO DELETE METADATA AND SUPPORT THE EXISTING LIBRARY BEHAVIOR
  private void deleteMetadata(DOI doi) throws DoiException{
    HttpPut request = new HttpPut(restApiWs + doi.getDoiName());
    String body = String.format("{\"data\":{\"type\":\"dois\",\"attributes\":{\"doi\":\"%s\",\"xml\":null}}}", doi.getDoiName());
    HttpEntity entity = new StringEntity(body, APPLICATION_JSON_UTF8);
    request.setEntity(entity);

    String auth = cfg.getUsername() + ":" + cfg.getPassword();
    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
    String authHeader = "Basic " + new String(encodedAuth);
    request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

    authCall(request);
  }

  @Override
  public void update(DOI doi, String metadata) throws DoiException {
    DataCiteValidator.validateMetadata(metadata);
    updateWithoutValidation(doi, metadata);
  }

  @Override
  public void update(DOI doi, DataCiteMetadata metadata) throws DoiException {
    updateWithoutValidation(doi, DataCiteValidator.toXml(doi, metadata));
  }

  private void updateWithoutValidation(DOI doi, String metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(metadata);

    DoiData status = resolve(doi);
    if (status == null || DoiStatus.REGISTERED != status.getStatus()) {
      throw new DoiException("DOI was not registered yet");
    }
    post(doi, metadataWs, metadata);
    LOG.info("Updated metadata for {}", doi);
  }

  @Override
  public void update(DOI doi, URI target) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(target);

    DoiData status = resolve(doi);
    if (status == null || DoiStatus.REGISTERED != status.getStatus()) {
      throw new DoiException("DOI was not registered yet");
    }
    authCall(buildDoiUrlPost(doi, target));
    LOG.info("Updated target URL for {}", doi);
  }

  private HttpPost buildDoiUrlPost(DOI doi, URI target) {
    HttpPost post = new HttpPost(doiWs);
    String body = String.format("doi=%s\nurl=%s", doi.getDoiName(), target);
    HttpEntity entity = new StringEntity(body, PLAIN_TEXT_UTF8);
    post.setEntity(entity);
    return post;
  }

  @VisibleForTesting
  protected URI doiUri(DOI doi) throws DoiException {
    try {
      return URI.create(doiWs.toString() + doi.getDoiName());
    } catch (IllegalArgumentException e) {
      throw new DoiException("Unable to convert DOI to DataCite URI", e);
    }
  }

  @VisibleForTesting
  protected URI metadataUri(DOI doi) throws DoiException {
    try {
      return URI.create(metadataWs.toString() + doi.getDoiName());
    } catch (IllegalArgumentException e) {
      throw new DoiException("Unable to convert DOI to DataCite URI", e);
    }
  }

  /**
   * Executes an HTTP POST request.
   *
   * @param uri  to issue request against
   * @param metadata request body content to be serialized as XML with jackson
   *
   * @throws org.gbif.doi.service.DoiException in case anything goes wrong during the request.
   */
  private void post(DOI doi, URI uri, String metadata) throws DoiException {
    LOG.debug("POST: {}", uri);
    HttpPost req = new HttpPost(uri);
    HttpEntity entity = new StringEntity(metadata, APPLICATION_XML_UTF8);
    req.setEntity(entity);

    authCall(req);
  }
}
