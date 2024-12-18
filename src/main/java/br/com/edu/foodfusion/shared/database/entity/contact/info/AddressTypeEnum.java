package br.com.edu.foodfusion.shared.database.entity.contact.info;

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
