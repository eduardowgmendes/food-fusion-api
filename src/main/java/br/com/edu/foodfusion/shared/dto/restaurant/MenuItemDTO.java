package br.com.edu.foodfusion.shared.dto.restaurant;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuItemEntity;
import br.com.edu.foodfusion.shared.dto.picture.ShowcasePictureDTO;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MenuItemDTO {

    private String name;
    private String description;
    private double unitPrice;
    private List<ShowcasePictureDTO> showcasePictures;

    public static MenuItemEntity toMenuItemEntity(MenuItemDTO menuItemDTO) {
        return new ModelMapper()
                .map(menuItemDTO, MenuItemEntity.class);
    }
}
