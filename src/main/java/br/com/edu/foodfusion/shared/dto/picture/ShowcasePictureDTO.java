package br.com.edu.foodfusion.shared.dto.picture;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.picture.ShowcasePictureEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowcasePictureDTO {

    private long id;
    private String base64;

    public static ShowcasePictureEntity toShowcasePictureEntity(ShowcasePictureEntity showcasePicture) {
        return new ModelMapper()
                .map(showcasePicture, ShowcasePictureEntity.class);
    }
}
