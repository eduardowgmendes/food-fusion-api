package br.com.edu.foodfusion.shared.dto.restaurant;

import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuEntity;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MenuDTO {

    private String name;
    private String description;
    private List<MenuItemDTO> items;

    public static MenuEntity toMenuEntity(MenuDTO menuDTO) {
        return new ModelMapper()
                .map(menuDTO, MenuEntity.class);
    }
}
