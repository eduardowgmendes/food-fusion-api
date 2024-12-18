package br.com.edu.foodfusion.shared.database.builder.entity;

import br.com.edu.foodfusion.shared.database.entity.contact.info.AddressEntity;

public class AddressEntityBuilder {

    private final AddressEntity addressEntity = new AddressEntity();

    public static AddressEntityBuilder anAddress() {
        return new AddressEntityBuilder();
    }

    public AddressEntityBuilder withStreet(String street) {
        this.addressEntity.setStreet(street);
        return this;
    }

    public AddressEntityBuilder withLocalNumber(String localNumber) {
        this.addressEntity.setLocalNumber(localNumber);
        return this;
    }

    public AddressEntityBuilder withNeighborhood(String neighborhood) {
        this.addressEntity.setNeighborhood(neighborhood);
        return this;
    }

    public AddressEntityBuilder withCity(String city) {
        this.addressEntity.setCity(city);
        return this;
    }

    public AddressEntityBuilder withState(String state) {
        this.addressEntity.setState(state);
        return this;
    }

    public AddressEntityBuilder withCountry(String country) {
        this.addressEntity.setCountry(country);
        return this;
    }

    public AddressEntityBuilder withZipcode(String zipcode) {
        this.addressEntity.setZipcode(zipcode);
        return this;
    }

    public AddressEntityBuilder withDefault() {
        this.addressEntity.setId(1);
        this.addressEntity.setStreet("Rua José Sergio");
        this.addressEntity.setLocalNumber("203");
        this.addressEntity.setNeighborhood("JD Maria Antônia");
        this.addressEntity.setCity("Sumaré");
        this.addressEntity.setState("São Paulo");
        this.addressEntity.setCountry("Brazil");
        this.addressEntity.setZipcode("13178416");
        return this;
    }

    public AddressEntity build() {
        return this.addressEntity;
    }

}
