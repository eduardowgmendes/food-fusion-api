package br.com.edu.foodfusion.shared.database.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CuisineTypeEnum {

    ITALIAN(1, "Italiana"),
    JAPANESE(2, "Japonesa"),
    THAI(3, "Tailandesa"),
    CHINESE(4, "Chinesa"),
    MEXICAN(5, "Mexicana"),
    INDIAN(6, "Indiana"),
    AMERICAN(7, "Americana"),
    FRENCH(8, "Francesa"),
    BRAZILIAN(9, "Brasileira"),
    MEDITERRANEAN(10, "Mediterrânea"),
    SPANISH(11, "Espanhola"),
    GREEK(12, "Grega"),
    KOREAN(13, "Coreana"),
    VIETNAMESE(15, "Vietnamita"),
    TURKISH(16, "Turca"),
    ARABIC(17, "Árabe");

    private final int code;
    private final String description;

    CuisineTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CuisineTypeEnum fromCode(int code) {
        for (CuisineTypeEnum cuisineTypeEnum : values())
            if (cuisineTypeEnum.getCode() == code) return cuisineTypeEnum;
        throw new IllegalArgumentException("Cuisine not found with given code: " + code);
    }

    public static void main(String[] args) {
        Arrays.stream(values()).forEach(System.out::println);
    }

}
