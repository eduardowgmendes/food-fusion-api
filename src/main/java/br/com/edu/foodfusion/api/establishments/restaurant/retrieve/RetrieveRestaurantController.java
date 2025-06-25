package br.com.edu.foodfusion.api.establishments.restaurant.retrieve;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.dto.restaurant.RestaurantDTO;
import br.com.edu.foodfusion.shared.response.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/retrieve/restaurants")
public class RetrieveRestaurantController {

    @Autowired
    private RetrieveRestaurantService retrieveRestaurantService;

    @GetMapping
    public ResponseEntity<DefaultResponse<List<RestaurantDTO>>> findAll(@RequestParam(name = "includeAll", required = false) Boolean includeAll) {
        List<RestaurantEntity> findings = null;

        if (includeAll != null) {
            if (includeAll) {
                findings = retrieveRestaurantService.findAll();
            } else {
                findings = retrieveRestaurantService.findAllNotErased();
            }
        } else {
            findings = retrieveRestaurantService.findAllNotErased();
        }

        if (findings.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the restaurants found: " + findings.size(), findings.stream()
                .map(RestaurantEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/by_name")
    public ResponseEntity<DefaultResponse<List<RestaurantDTO>>> findAllByName(@RequestParam(name = "name") String name) {
        List<RestaurantEntity> restaurantsFound = retrieveRestaurantService.findAllByName(name);

        if (restaurantsFound.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the restaurants found.", restaurantsFound.stream()
                .map(RestaurantEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/by_type")
    public ResponseEntity<DefaultResponse<List<RestaurantDTO>>> findAllByType(@RequestParam(name = "type") String type) {

        List<RestaurantEntity> restaurantsFound = retrieveRestaurantService.findAllByType(type);

        if (restaurantsFound.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the restaurants found.", restaurantsFound.stream()
                .map(RestaurantEntity::toDTO)
                .collect(Collectors.toList())));
    }

}
