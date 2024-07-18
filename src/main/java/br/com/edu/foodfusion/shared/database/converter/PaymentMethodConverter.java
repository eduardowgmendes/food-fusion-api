package br.com.edu.foodfusion.shared.database.converter;

import br.com.edu.foodfusion.shared.database.enums.PaymentMethodEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentMethodConverter implements AttributeConverter<PaymentMethodEnum, String> {
    @Override
    public String convertToDatabaseColumn(PaymentMethodEnum attribute) {
        if (attribute == null) return null;
        return attribute.name();
    }

    @Override
    public PaymentMethodEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return PaymentMethodEnum.valueOf(dbData);
    }
}
