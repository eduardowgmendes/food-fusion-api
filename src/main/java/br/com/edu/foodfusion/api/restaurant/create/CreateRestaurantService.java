package br.com.edu.foodfusion.api.restaurant.create;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class CreateRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantEntity create(RestaurantEntity restaurant) {
        if (restaurant != null) {
            restaurant.setCreatedAt(LocalDateTime.now());
            return restaurantRepository.save(restaurant);
        }
        return null;
    }

}
