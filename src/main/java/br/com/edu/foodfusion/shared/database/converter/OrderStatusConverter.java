package br.com.edu.foodfusion.shared.database.converter;

import br.com.edu.foodfusion.shared.database.enums.OrderStatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(OrderStatusEnum attribute) {
        if (attribute == null) return null;
        return attribute.name();
    }

    @Override
    public OrderStatusEnum convertToEntityAttribute(String attribute) {
        if (attribute == null) return null;
        return OrderStatusEnum.valueOf(attribute);
    }
}
