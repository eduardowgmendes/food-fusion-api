package br.com.edu.foodfusion.shared.database.converter;

import br.com.edu.foodfusion.shared.database.entity.contact.info.AddressTypeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AddressTypeConverter implements AttributeConverter<AddressTypeEnum, String> {

    @Override
    public String convertToDatabaseColumn(AddressTypeEnum attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public AddressTypeEnum convertToEntityAttribute(String value) {
        return value == null ? null : AddressTypeEnum.valueOf(value);
    }
}
