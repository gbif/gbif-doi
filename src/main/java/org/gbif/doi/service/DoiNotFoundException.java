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

import org.gbif.api.model.common.DOI;

/** Happening when trying to delete or update a non-existing DOI. */
public class DoiNotFoundException extends DoiException {
  private final DOI doi;

  public DoiNotFoundException(Throwable cause, DOI doi) {
    super(cause);
    this.doi = doi;
  }

  public DoiNotFoundException(String message, DOI doi) {
    super(message);
    this.doi = doi;
  }

  public DOI getDoi() {
    return doi;
  }
}
