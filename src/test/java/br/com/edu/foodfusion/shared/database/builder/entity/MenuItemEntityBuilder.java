package br.com.edu.foodfusion.shared.database.builder.entity;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.picture.ShowcasePictureEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuItemEntity;

import java.util.List;

import static br.com.edu.foodfusion.shared.database.builder.entity.ShowcasePictureEntityBuilder.*;

public class MenuItemEntityBuilder {

    private final MenuItemEntity menuItemEntity = new MenuItemEntity();

    public static MenuItemEntityBuilder anMenuItem() {
        return new MenuItemEntityBuilder();
    }

    public MenuItemEntityBuilder withId(long menuItemId) {
        this.menuItemEntity.setId(menuItemId);
        return this;
    }

    public MenuItemEntityBuilder withName(String name) {
        this.menuItemEntity.setName(name);
        return this;
    }

    public MenuItemEntityBuilder withDescription(String description) {
        this.menuItemEntity.setDescription(description);
        return this;
    }

    public MenuItemEntityBuilder withShowCasePictures(List<ShowcasePictureEntity> showCasePictures) {
        this.menuItemEntity.setShowcasePictures(showCasePictures);
        return this;
    }

    public MenuItemEntityBuilder withDefault() {
        this.menuItemEntity.setId(1);
        this.menuItemEntity.setName("Item A");
        this.menuItemEntity.setDescription("Item A only for testes purposes.");
        this.menuItemEntity.setShowcasePictures(List.of(
                anPicture()
                        .withDefault()
                        .build(),
                anPicture()
                        .withDefault()
                        .build(),
                anPicture()
                        .withDefault()
                        .build()));
        return this;
    }

    public MenuItemEntity build() {
        return this.menuItemEntity;
    }
}
