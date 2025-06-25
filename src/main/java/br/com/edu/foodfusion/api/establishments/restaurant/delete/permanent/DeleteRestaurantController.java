package br.com.edu.foodfusion.api.establishments.restaurant.delete.permanent;

import br.com.edu.foodfusion.shared.response.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/v1/delete/restaurant")
public class DeleteRestaurantController {

    @Autowired
    private DeleteRestaurantService deleteRestaurantService;

    @DeleteMapping("/by_id/{restaurantId}")
    public ResponseEntity<DefaultResponse<Long>> delete(@PathVariable("restaurantId") long restaurantId) {
        deleteRestaurantService.delete(restaurantId);
        return ResponseEntity
                .ok(DefaultResponse.create(true, format("Restaurant %d deleted with success", restaurantId), restaurantId));
    }

    @DeleteMapping("/all")
    public ResponseEntity<DefaultResponse<String>> deleteAll() {
        deleteRestaurantService.clear();
        return ResponseEntity
                .ok(DefaultResponse.create(true, "All restaurants has gone.", null));
    }

}