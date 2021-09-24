package jss.ecommerce.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jss.ecommerce.api.entity.Localidade;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class LocalidadeToJSONConverter implements AttributeConverter<Localidade, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Localidade target) {
        try {
            return objectMapper.writeValueAsString(target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Localidade convertToEntityAttribute(String target) {
        try {
            return objectMapper.readValue(target, Localidade.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
