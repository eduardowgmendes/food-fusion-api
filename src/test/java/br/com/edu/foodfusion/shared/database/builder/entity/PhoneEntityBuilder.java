package br.com.edu.foodfusion.shared.database.builder.entity;

import br.com.edu.foodfusion.shared.database.entity.contact.info.PhoneEntity;

public class PhoneEntityBuilder {

    private final PhoneEntity phoneEntity = new PhoneEntity();

    public static PhoneEntityBuilder anPhone() {
        return new PhoneEntityBuilder();
    }

    public PhoneEntityBuilder withId(long phoneId) {
        this.phoneEntity.setId(phoneId);
        return this;
    }

    public PhoneEntityBuilder withPrefix(String prefix) {
        this.phoneEntity.setPrefix(prefix);
        return this;
    }

    public PhoneEntityBuilder withPhoneNumber(String phoneNumber) {
        this.phoneEntity.setPhoneNumber(phoneNumber);
        return this;
    }

    public PhoneEntityBuilder withDefault() {
        this.phoneEntity.setId(1);
        this.phoneEntity.setPrefix("+55");
        this.phoneEntity.setPhoneNumber("19982091363");
        return this;
    }

    public PhoneEntity build() {
        return this.phoneEntity;
    }

}
