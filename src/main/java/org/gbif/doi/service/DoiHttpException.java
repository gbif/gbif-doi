/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gbif.doi.service;

/**
 * Happening when there are some problems on DataCite side (service responded with an HTTP error).
 */
public class DoiHttpException extends DoiException {
  private final int status;

  public DoiHttpException(int status) {
    super("HTTP " + status);
    this.status = status;
  }

  public DoiHttpException(int status, String message) {
    super("HTTP " + status + ": " + message);
    this.status = status;
  }

  public DoiHttpException(int status, String message, String additionalInformation) {
    super("HTTP " + status + ": " + message + " (" + additionalInformation + ")");
    this.status = status;
  }

  public DoiHttpException(Throwable cause, int status) {
    super("HTTP " + status, cause);
    this.status = status;
  }

  public int getStatus() {
    return status;
  }
}
