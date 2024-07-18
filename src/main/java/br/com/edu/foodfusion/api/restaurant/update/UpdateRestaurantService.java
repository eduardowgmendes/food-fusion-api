package br.com.edu.foodfusion.api.restaurant.update;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class UpdateRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantEntity update(long restaurantId, RestaurantEntity restaurantUpdate) {
        RestaurantEntity restaurantFound = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurantFound != null) {
            restaurantFound.setId(restaurantId);
            restaurantFound.setName(restaurantUpdate.getName());
            restaurantFound.setDescription(restaurantUpdate.getDescription());
            restaurantFound.setLogo(restaurantUpdate.getLogo());
            restaurantFound.setAddresses(restaurantUpdate.getAddresses());
            restaurantFound.setPhones(restaurantUpdate.getPhones());
            restaurantFound.setMenus(restaurantUpdate.getMenus());
            restaurantFound.setType(restaurantUpdate.getType());
            restaurantFound.setUpdatedAt(LocalDateTime.now());
            return restaurantRepository.save(restaurantFound);
        }

        return null;
    }

}
