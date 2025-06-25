package br.com.edu.foodfusion.shared.database.builder.entity;

import br.com.edu.foodfusion.shared.database.entity.contact.address.AddressEntity;
import br.com.edu.foodfusion.shared.database.entity.contact.phone.PhoneEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.database.enums.CuisineTypeEnum;

import java.util.List;

import static br.com.edu.foodfusion.shared.database.builder.entity.MenuEntityBuilder.*;
import static java.util.List.of;

public class RestaurantEntityBuilder {

    private final RestaurantEntity establishmentEntity = new RestaurantEntity();

    public static RestaurantEntityBuilder anRestaurant() {
        return new RestaurantEntityBuilder();
    }

    public RestaurantEntityBuilder withId(long restaurantId) {
        this.establishmentEntity.setId(restaurantId);
        return this;
    }

    public RestaurantEntityBuilder withName(String name) {
        this.establishmentEntity.setName(name);
        return this;
    }

    public RestaurantEntityBuilder withDescription(String description) {
        this.establishmentEntity.setDescription(description);
        return this;
    }

    public RestaurantEntityBuilder withLogo(String logo) {
        this.establishmentEntity.setLogo(logo);
        return this;
    }

    public RestaurantEntityBuilder withAddress(AddressEntity addresses) {
        this.establishmentEntity.setAddress(addresses);
        return this;
    }

    public RestaurantEntityBuilder withPhone(PhoneEntity phone) {
        this.establishmentEntity.setPhone(phone);
        return this;
    }

    public RestaurantEntityBuilder withMenus(List<MenuEntity> menus) {
        this.establishmentEntity.setMenus(menus);
        return this;
    }

    public RestaurantEntityBuilder withCuisineType(CuisineTypeEnum type) {
        this.establishmentEntity.setType(type);
        return this;
    }

    public RestaurantEntityBuilder withDefault() {
        this.establishmentEntity.setId(1);
        this.establishmentEntity.setName("Simple Restaurant");
        this.establishmentEntity.setDescription("A simple restaurant");
        this.establishmentEntity.setLogo("base64-logo");
        this.establishmentEntity.setAddress(null);
        this.establishmentEntity.setPhone(null);
        this.establishmentEntity.setMenus(of(anMenu()
                .withDefault()
                .build()));
        this.establishmentEntity.setType(CuisineTypeEnum.AMERICAN);
        return this;
    }

    public RestaurantEntity build() {
        return this.establishmentEntity;
    }

}
