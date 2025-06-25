package br.com.edu.foodfusion.shared.database.enums;

public enum AddressTypeEnum {

    RESIDENTIAL("Residential"),
    COMMERCIAL("Commercial"),
    CORRESPONDENCE("Correspondence");

    private final String displayName;

    AddressTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isCorrespondence() {
        return this == CORRESPONDENCE;
    }

    public boolean isCommercial() {
        return this == COMMERCIAL;
    }

    public boolean isResidential() {
        return this == RESIDENTIAL;
    }
}
