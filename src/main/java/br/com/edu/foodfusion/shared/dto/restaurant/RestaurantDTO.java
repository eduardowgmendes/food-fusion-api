package br.com.edu.foodfusion.shared.dto.restaurant;

import br.com.edu.foodfusion.shared.database.enums.CuisineType;
import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.dto.contact.info.AddressDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.PhoneDTO;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RestaurantDTO {

    private long id;
    private String name;
    private String description;
    private CuisineType type;
    private String logo;
    private List<AddressDTO> addresses;
    private List<PhoneDTO> phones;
    private List<MenuDTO> menus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isDeleted;

    public static RestaurantEntity toRestaurantEntity(RestaurantDTO restaurantDTO) {
        return new ModelMapper()
                .map(restaurantDTO, RestaurantEntity.class);
    }

}
