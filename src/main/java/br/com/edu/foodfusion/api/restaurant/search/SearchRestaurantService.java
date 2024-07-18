package br.com.edu.foodfusion.api.restaurant.search;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantEntity getById(long id) {
        return restaurantRepository.findById(id)
                .orElse(null);
    }

}
