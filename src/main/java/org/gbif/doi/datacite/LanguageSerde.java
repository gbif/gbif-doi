package org.gbif.doi.datacite;

import org.gbif.api.vocabulary.Language;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


/**
 * Jackson Language ISO code (de)serializer.
 * TODO: move into API project?
 */
public class LanguageSerde {
  public static final Serializer serializer = new Serializer();
  public static final Deserializer deserializer = new Deserializer();

  /**
   * Serializes the value in a 2 letter ISO format.
   */
  public static class Serializer extends JsonSerializer<Language> {

    @Override
    public void serialize(Language value, com.fasterxml.jackson.core.JsonGenerator jgen, SerializerProvider provider) throws IOException {
      jgen.writeString(value.getIso3LetterCode());
    }
  }

  /**
   * Deserializes the value from a 2 letter ISO format.
   */
  public static class Deserializer extends JsonDeserializer<Language> {

    @Override
    public Language deserialize(com.fasterxml.jackson.core.JsonParser jp,
      com.fasterxml.jackson.databind.DeserializationContext ctxt) throws IOException {
      try {
        if (jp != null && jp.getTextLength() > 0) {
          return Language.fromIsoCode(jp.getText());
        } else {
          return Language.UNKNOWN; // none provided
        }
      } catch (Exception e) {
        throw new IOException("Unable to deserialize language from provided value (not an ISO 2/3 character?): "
                              + jp.getText());
      }
    }
  }

}
