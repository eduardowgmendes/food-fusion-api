package br.com.edu.foodfusion.shared.database.enums;

import lombok.Getter;

@Getter
public enum PaymentMethodEnum {
    CASH("Cash"),
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    BANK_TRANSFER("Bank Transfer"),
    DIGITAL_WALLET("Digital Wallet"), // Can be further sub-categorized),
    ELECTRONIC_CHECK("Electronic Check"),  // Less common, consider removing if not applicable),
    COD("Cash on Delivery"),
    FINANCING("Financing");

    private final String displayName;

    PaymentMethodEnum(String displayName) {
        this.displayName = displayName;
    }
}
