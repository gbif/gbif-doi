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

/** Any exception happening during requests with agency APIs will be converted to this exception. */
public class DoiException extends Exception {

  public DoiException() {}

  public DoiException(String message) {
    super(message);
  }

  public DoiException(Throwable cause) {
    super(cause);
  }

  public DoiException(String message, Throwable cause) {
    super(message, cause);
  }
}
