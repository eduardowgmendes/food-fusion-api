package br.com.edu.foodfusion.shared.database.converter;

import br.com.edu.foodfusion.shared.database.enums.CuisineType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CuisineTypeConverter implements AttributeConverter<CuisineType, String> {

    @Override
    public String convertToDatabaseColumn(CuisineType attribute) {
        if (attribute == null) return null;
        return attribute.name();
    }

    @Override
    public CuisineType convertToEntityAttribute(String attribute) {
        if (attribute == null) return null;
        return CuisineType.valueOf(attribute);
    }

}
