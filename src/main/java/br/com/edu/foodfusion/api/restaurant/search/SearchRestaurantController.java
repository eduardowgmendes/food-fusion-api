package br.com.edu.foodfusion.api.restaurant.search;

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

@RestController
@RequestMapping("/api/v1/search/restaurants")
public class SearchRestaurantController {

    @Autowired
    private SearchRestaurantService searchRestaurantService;

    @GetMapping(value = "/{restaurantId}")
    public ResponseEntity<DefaultResponse<RestaurantDTO>> findById(@PathVariable(name = "restaurantId") long restaurantId) {
        RestaurantEntity restaurant = searchRestaurantService.getById(restaurantId);

        if (restaurant == null)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity
                .ok(DefaultResponse.create(true, "Here is the restaurant found.", RestaurantEntity.toDTO(restaurant)));
    }

}
