package br.com.edu.foodfusion.shared.database.enums;

public enum EstablishmentTypeEnum {

    RESTAURANT(1, "Restaurante"),
    PIZZERIA(2, "Pizzaria"),
    SUPERMARKET(3, "Supermercado"),
    BAR(4, "Bar"),
    COFFEE_SHOP(5, "Cafeteria"),
    SNACK_BAR(6, "Lanchonete");

    private final int code;
    private final String description;

    EstablishmentTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static EstablishmentTypeEnum fromCode(int code) {
        for (EstablishmentTypeEnum type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("EstablishmentTyṕe not found with given code: " + code);
    }
}

