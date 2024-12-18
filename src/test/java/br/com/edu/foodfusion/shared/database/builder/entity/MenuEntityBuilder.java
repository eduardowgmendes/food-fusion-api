package br.com.edu.foodfusion.shared.database.builder.entity;

import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuEntity;
import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuItemEntity;

import java.util.List;

import static br.com.edu.foodfusion.shared.database.builder.entity.MenuItemEntityBuilder.anMenuItem;
import static br.com.edu.foodfusion.shared.database.builder.entity.ShowcasePictureEntityBuilder.*;
import static java.util.List.of;

public class MenuEntityBuilder {

    private final MenuEntity menuEntity = new MenuEntity();

    public static MenuEntityBuilder anMenu() {
        return new MenuEntityBuilder();
    }

    public MenuEntityBuilder withId(long menuId) {
        this.menuEntity.setId(menuId);
        return this;
    }

    public MenuEntityBuilder withName(String name) {
        this.menuEntity.setName(name);
        return this;
    }

    public MenuEntityBuilder withDescription(String description) {
        this.menuEntity.setDescription(description);
        return this;
    }

    public MenuEntityBuilder withItems(List<MenuItemEntity> items) {
        this.menuEntity.setItems(items);
        return this;
    }

    public MenuEntityBuilder withDefault() {
        this.menuEntity.setId(1);
        this.menuEntity.setName("Menu A");
        this.menuEntity.setDescription("Menu A for tests purposes");
        this.menuEntity.setItems(of(
                anMenuItem()
                        .withName("Item A")
                        .withDescription("Item A for tests purposes")
                        .withShowCasePictures(of(
                                        anPicture().withDefault().build(),
                                        anPicture().withDefault().build(),
                                        anPicture().withDefault().build()))
                                        .build(),
                anMenuItem()
                        .withName("Item B")
                        .withDescription("Item B for tests purposes")
                        .withShowCasePictures(of(
                                        anPicture().withDefault().build(),
                                        anPicture().withDefault().build(),
                                        anPicture().withDefault().build()))
                                        .build(),
                anMenuItem()
                        .withName("Item C")
                        .withDescription("Item C for tests purposes")
                        .withShowCasePictures(of(
                                        anPicture().withDefault().build(),
                                        anPicture().withDefault().build(),
                                        anPicture().withDefault().build()))
                                        .build()));
        return this;
    }

    public MenuEntity build() {
        return this.menuEntity;
    }

}
