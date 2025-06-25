package br.com.edu.foodfusion.shared.database.builder.entity;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.picture.ShowcasePictureEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuItemEntity;

public class ShowcasePictureEntityBuilder {

    private final ShowcasePictureEntity picture = new ShowcasePictureEntity();

    public static ShowcasePictureEntityBuilder anPicture() {
        return new ShowcasePictureEntityBuilder();
    }

    public ShowcasePictureEntityBuilder withId(long pictureId) {
        this.picture.setId(pictureId);
        return this;
    }

    public ShowcasePictureEntityBuilder withBase64(String base64) {
        this.picture.setBase64(base64);
        return this;
    }

    public ShowcasePictureEntityBuilder withDefault() {
        this.picture.setId(1);
        this.picture.setBase64("base64-image-code");

        MenuItemEntity menuItemEntity = MenuItemEntityBuilder
                .anMenuItem()
                .withDefault()
                .build();

        this.picture.setMenuItem(menuItemEntity);

        return this;
    }

    public ShowcasePictureEntity build() {
        return this.picture;
    }

}
