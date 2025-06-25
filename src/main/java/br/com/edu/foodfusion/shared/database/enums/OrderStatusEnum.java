package br.com.edu.foodfusion.shared.database.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    CREATED(1, "Criado"),
    IN_PREPARATION(2, "Em Preparo"),
    READY(3, "Pronto"),
    DELIVERED(4, "Entregue"),
    CANCELED(5, "Cancelado");

    private final String description;
    private final int code;

    OrderStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OrderStatusEnum fromCode(int code) {
        for (OrderStatusEnum orderStatusEnum : values())
            if (orderStatusEnum.getCode() == code) return orderStatusEnum;
        throw new IllegalArgumentException("Status not found with given code: " + code);
    }

}
