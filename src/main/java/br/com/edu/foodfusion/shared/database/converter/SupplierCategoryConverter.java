package br.com.edu.foodfusion.shared.database.converter;

import br.com.edu.foodfusion.shared.database.enums.SupplierCategoryEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SupplierCategoryConverter implements AttributeConverter<SupplierCategoryEnum, String> {

    @Override
    public String convertToDatabaseColumn(SupplierCategoryEnum attribute) {
        if (attribute == null) return null;
        return attribute.name();
    }

    @Override
    public SupplierCategoryEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return SupplierCategoryEnum.valueOf(dbData);
    }
}
