package br.com.edu.foodfusion.shared.database.builder.entity;

import br.com.edu.foodfusion.shared.database.entity.contact.info.AddressEntity;
import br.com.edu.foodfusion.shared.database.entity.contact.info.PhoneEntity;
import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuEntity;
import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.database.enums.CuisineType;

import java.util.List;

import static br.com.edu.foodfusion.shared.database.builder.entity.AddressEntityBuilder.*;
import static br.com.edu.foodfusion.shared.database.builder.entity.MenuEntityBuilder.*;
import static br.com.edu.foodfusion.shared.database.builder.entity.PhoneEntityBuilder.*;
import static java.util.List.of;

public class RestaurantEntityBuilder {

    private final RestaurantEntity restaurantEntity = new RestaurantEntity();

    public static RestaurantEntityBuilder anRestaurant() {
        return new RestaurantEntityBuilder();
    }

    public RestaurantEntityBuilder withId(long restaurantId) {
        this.restaurantEntity.setId(restaurantId);
        return this;
    }

    public RestaurantEntityBuilder withName(String name) {
        this.restaurantEntity.setName(name);
        return this;
    }

    public RestaurantEntityBuilder withDescription(String description) {
        this.restaurantEntity.setDescription(description);
        return this;
    }

    public RestaurantEntityBuilder withLogo(String logo) {
        this.restaurantEntity.setLogo(logo);
        return this;
    }

    public RestaurantEntityBuilder withAddresses(List<AddressEntity> addresses) {
        this.restaurantEntity.setAddresses(addresses);
        return this;
    }

    public RestaurantEntityBuilder withPhones(List<PhoneEntity> phones) {
        this.restaurantEntity.setPhones(phones);
        return this;
    }

    public RestaurantEntityBuilder withMenus(List<MenuEntity> menus) {
        this.restaurantEntity.setMenus(menus);
        return this;
    }

    public RestaurantEntityBuilder withCuisineType(CuisineType type) {
        this.restaurantEntity.setType(type);
        return this;
    }

    public RestaurantEntityBuilder withDefault() {
        this.restaurantEntity.setId(1);
        this.restaurantEntity.setName("Simple Restaurant");
        this.restaurantEntity.setDescription("A simple restaurant");
        this.restaurantEntity.setLogo("base64-logo");
        this.restaurantEntity.setAddresses(of(
                anAddress()
                .withDefault()
                .build()));
        this.restaurantEntity.setPhones(of(anPhone()
                .withDefault()
                .build()));
        this.restaurantEntity.setMenus(of(anMenu()
                .withDefault()
                .build()));
        this.restaurantEntity.setType(CuisineType.AMERICAN);
        return this;
    }

    public RestaurantEntity build() {
        return this.restaurantEntity;
    }

}
