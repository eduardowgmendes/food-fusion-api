package br.com.edu.foodfusion.api.restaurant.retrieve;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrieveRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantEntity> findAll() {
        return restaurantRepository.findAll();
    }

    public List<RestaurantEntity> findAllNotErased() {
        return restaurantRepository.findAllNotErased()
                .orElse(null);
    }

    public List<RestaurantEntity> findAllByName(String name) {
        return restaurantRepository.findByNameLike(name)
                .orElse(null);
    }

    public List<RestaurantEntity> findAllByType(String type) {
        return restaurantRepository.findByType(type)
                .orElse(null);
    }

}
