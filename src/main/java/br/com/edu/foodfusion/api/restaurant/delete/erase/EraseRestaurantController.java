package br.com.edu.foodfusion.api.restaurant.delete.erase;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.dto.restaurant.RestaurantDTO;
import br.com.edu.foodfusion.shared.response.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/v1/erase/restaurant")
public class EraseRestaurantController {

    @Autowired
    private EraseRestaurantService eraseRestaurantService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<DefaultResponse<RestaurantDTO>> trash(@PathVariable(name = "restaurantId") long restaurantId) {
        RestaurantEntity restaurantErased = eraseRestaurantService.erase(restaurantId);

        if (restaurantErased != null)
            return ResponseEntity
                    .ok(DefaultResponse.create(true, format("Restaurant %d erased with success", restaurantId), RestaurantEntity.toDTO(restaurantErased)));

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DefaultResponse.create(false, format("Restaurant %d not found to be erased.", restaurantId), null));
    }

    @GetMapping("/recover/{restaurantId}")
    public ResponseEntity<DefaultResponse<RestaurantDTO>> recover(@PathVariable(name = "restaurantId") long restaurantId) {
        RestaurantEntity restaurantRecovered = eraseRestaurantService.recover(restaurantId);

        if (restaurantRecovered != null)
            return ResponseEntity
                    .ok(DefaultResponse.create(true, format("Restaurant %d recovered with success", restaurantId), RestaurantEntity.toDTO(restaurantRecovered)));

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DefaultResponse.create(false, format("Restaurant %d not found to be erased.", restaurantId), null));
    }

}
