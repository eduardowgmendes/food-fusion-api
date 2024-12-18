package br.com.edu.foodfusion.api.restaurant.delete.permanent;

import br.com.edu.foodfusion.shared.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void delete(long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    public void clear() {
        restaurantRepository.deleteAll();// set deleteAt to LocalDateTime.now();
    }

}
