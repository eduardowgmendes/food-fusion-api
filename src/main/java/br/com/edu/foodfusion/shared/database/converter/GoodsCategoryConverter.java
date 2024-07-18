package br.com.edu.foodfusion.shared.database.converter;

import br.com.edu.foodfusion.shared.database.enums.GoodsCategoryEnum;
import jakarta.persistence.AttributeConverter;

public class GoodsCategoryConverter implements AttributeConverter<GoodsCategoryEnum, String> {
    @Override
    public String convertToDatabaseColumn(GoodsCategoryEnum attribute) {
        if (attribute == null) return null;
        return attribute.name();
    }

    @Override
    public GoodsCategoryEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return GoodsCategoryEnum.valueOf(dbData);
    }
}
