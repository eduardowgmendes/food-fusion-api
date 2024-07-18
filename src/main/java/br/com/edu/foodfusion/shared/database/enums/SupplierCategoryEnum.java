package br.com.edu.foodfusion.shared.database.enums;

import lombok.Getter;

@Getter
public enum SupplierCategoryEnum {
    ELECTRONICS("Electronics"),
    FOOD_BEVERAGE("Food & Beverage"),
    OFFICE_SUPPLIES("Office Supplies"),
    AUTOMOTIVE("Automotive"),
    APPAREL("Apparel"),
    RAW_MATERIALS("Raw Materials"),
    PACKAGING("Packaging"),
    MACHINERY("Machinery"),
    FURNITURE("Furniture"),
    CLEANING_SUPPLIES("Cleaning Supplies"),
    MEDICAL_SUPPLIES("Medical Supplies"),
    CONSTRUCTION("Construction"),
    IT_SERVICES("IT Services"),
    MARKETING_SERVICES("Marketing Services"),
    PROFESSIONAL_SERVICES("Professional Services"),
    AGRICULTURE("Agriculture"),
    PRINTING("Printing"),

    // Food Subcategories (assuming these are subcategories of FOOD_BEVERAGE)
    PRODUCE("Produce"),
    MEAT_SEAFOOD("Meat & Seafood"),
    DAIRY("Dairy"),
    BAKERY("Bakery"),
    GROCERY("Grocery"),
    BEVERAGES("Beverages"),
    CONDIMENTS("Condiments"),
    FROZEN_FOOD("Frozen Food"),

    SANITATION("Sanitation"),
    EQUIPMENT("Equipment"),
    INGREDIENTS("Ingredients"),
    SEAFOOD("Seafood"); // Separate category if needed

    private final String displayName;

    SupplierCategoryEnum(String displayName) {
        this.displayName = displayName;
    }

}
