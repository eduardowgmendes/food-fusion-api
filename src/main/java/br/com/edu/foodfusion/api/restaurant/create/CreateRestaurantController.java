package br.com.edu.foodfusion.api.restaurant.create;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.dto.restaurant.RestaurantDTO;
import br.com.edu.foodfusion.shared.request.CreateRestaurantRequest;
import br.com.edu.foodfusion.shared.response.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/create/restaurant")
public class CreateRestaurantController {

    @Autowired
    private CreateRestaurantService createRestaurantService;

    @PostMapping
    public ResponseEntity<DefaultResponse<RestaurantDTO>> create(@RequestBody CreateRestaurantRequest request) {
        RestaurantEntity createdRestaurant = createRestaurantService.create(RestaurantDTO.toRestaurantEntity(request.getNewRestaurant()));

        if (createdRestaurant != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(DefaultResponse.create(true, "Restaurant created with success!", RestaurantEntity.toDTO(createdRestaurant)));

        return ResponseEntity.badRequest().body(DefaultResponse.create(false, "Failed to create a new restaurant.", null));
    }

}
