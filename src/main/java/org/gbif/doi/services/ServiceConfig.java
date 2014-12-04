package org.gbif.doi.services;

import java.net.URI;
import javax.annotation.Nullable;

public class ServiceConfig {
  private URI api;
  private String username;
  private String password;

  /**
   * The base URL of the API the service implementation works against.
   * All service implementation provide a default URI which will be used if this setting is NULL.
   */
  @Nullable
  public URI getApi() {
    return api;
  }

  public void setApi(URI api) {
    this.api = api;
  }

  /**
   * The username (symbol in DataCite) to authenticate with.
   * This determines which DOI prefix and target URL domains can be used.
   */
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * The password to authenticate with.
   */
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "ServiceConfig{" +
           "api=" + api +
           ", username='" + username + '\'' +
           ", password='" + password + '\'' +
           '}';
  }
}
