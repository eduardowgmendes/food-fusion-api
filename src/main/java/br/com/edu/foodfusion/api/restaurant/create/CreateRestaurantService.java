package br.com.edu.foodfusion.api.restaurant.create;

import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuEntity;
import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuItemEntity;
import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.repository.MenuRepository;
import br.com.edu.foodfusion.shared.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CreateRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    public RestaurantEntity create(RestaurantEntity restaurant) {
        if (restaurant != null) {
            restaurant.setCreatedAt(LocalDateTime.now());

            restaurant.getServiceTimes()
                    .forEach(serviceTime -> serviceTime.setRestaurant(restaurant));

            return restaurantRepository.save(restaurant);
        }
        return null;
    }

    public RestaurantEntity addMenu(long restaurantId, MenuEntity menu) {
        RestaurantEntity restaurantFound = restaurantRepository.findById(restaurantId)
                .orElse(null);

        if (restaurantFound != null) {
            menu.setRestaurant(restaurantFound);
            List<MenuItemEntity> items = menu.getItems();
            items.forEach(menuItem -> menuItem.setMenu(menu));
            items.forEach(menuItem -> menuItem.getShowcasePictures()
                    .forEach(showcasePicture -> showcasePicture.setMenuItem(menuItem)));

            menuRepository.save(menu);
        }

        return restaurantFound;
    }

}
