package br.com.edu.foodfusion.api.restaurant.delete.erase;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EraseRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantEntity erase(long restaurantId) {
        RestaurantEntity restaurantFound = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurantFound != null) {
            restaurantFound.setDeleted(true);
            restaurantFound.setDeletedAt(LocalDateTime.now());
            return restaurantRepository.save(restaurantFound);
        }

        return null;
    }

    public RestaurantEntity recover(long restaurantId) {
        RestaurantEntity restaurantFound = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurantFound != null) {
            restaurantFound.setDeleted(false);
            restaurantFound.setDeletedAt(null);
            return restaurantRepository.save(restaurantFound);
        }

        return null;
    }
}
