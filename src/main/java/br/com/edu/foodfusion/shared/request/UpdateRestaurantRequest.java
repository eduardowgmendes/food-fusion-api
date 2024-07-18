package br.com.edu.foodfusion.shared.request;

import br.com.edu.foodfusion.shared.dto.restaurant.RestaurantDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRestaurantRequest {

    private long restaurantId;
    private RestaurantDTO restaurant;

}
