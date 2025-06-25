package br.com.edu.foodfusion.shared.database.converter;

import br.com.edu.foodfusion.shared.database.enums.CuisineTypeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CuisineTypeConverter implements AttributeConverter<CuisineTypeEnum, String> {

    @Override
    public String convertToDatabaseColumn(CuisineTypeEnum attribute) {
        if (attribute == null) return null;
        return attribute.name();
    }

    @Override
    public CuisineTypeEnum convertToEntityAttribute(String attribute) {
        if (attribute == null) return null;
        return CuisineTypeEnum.valueOf(attribute);
    }

}
