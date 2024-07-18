package br.com.edu.foodfusion.api.restaurant.update;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.dto.restaurant.RestaurantDTO;
import br.com.edu.foodfusion.shared.request.UpdateRestaurantRequest;
import br.com.edu.foodfusion.shared.response.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/update/restaurant")
public class UpdateRestaurantController {

    @Autowired
    private UpdateRestaurantService updateRestaurantService;

    @PostMapping
    public ResponseEntity<DefaultResponse<RestaurantDTO>> update(@RequestBody UpdateRestaurantRequest restaurantRequest) {
        long restaurantId = restaurantRequest.getRestaurantId();

        RestaurantEntity updatedRestaurant = updateRestaurantService.update(restaurantId, RestaurantDTO.toRestaurantEntity(restaurantRequest.getRestaurant()));

        if (updatedRestaurant == null)
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters", null));

        return ResponseEntity
                .ok(DefaultResponse
                        .create(true, "Restaurant updated with success.", RestaurantEntity
                                .toDTO(updatedRestaurant)));
    }

}
