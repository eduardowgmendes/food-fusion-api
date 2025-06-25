package br.com.edu.foodfusion.shared.dto.restaurant;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.database.enums.CuisineTypeEnum;
import br.com.edu.foodfusion.shared.dto.contact.info.AddressDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.PhoneDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.email.EmailDTO;
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
    private CuisineTypeEnum type;
    private String logo;
    private String backdrop;
    private AddressDTO address;
    private PhoneDTO phone;
    private List<MenuDTO> menus;
    private EmailDTO email;
    private List<ServiceTimeDTO> serviceTimes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isDeleted;

    public static RestaurantEntity toRestaurantEntity(RestaurantDTO restaurantDTO) {
        return new ModelMapper()
                .map(restaurantDTO, RestaurantEntity.class);
    }

}
