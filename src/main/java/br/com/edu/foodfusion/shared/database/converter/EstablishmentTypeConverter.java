package br.com.edu.foodfusion.shared.database.converter;

import br.com.edu.foodfusion.shared.database.enums.EstablishmentTypeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstablishmentTypeConverter implements AttributeConverter<EstablishmentTypeEnum, String> {
    @Override
    public String convertToDatabaseColumn(EstablishmentTypeEnum attribute) {
        if (attribute == null) return null;
        return attribute.name();
    }

    @Override
    public EstablishmentTypeEnum convertToEntityAttribute(String attribute) {
        if (attribute == null) return null;
        return EstablishmentTypeEnum.valueOf(attribute);
    }
}
