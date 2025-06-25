package br.com.edu.foodfusion.api.establishments.restaurant.update;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuItemEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.repository.MenuItemRepository;
import br.com.edu.foodfusion.shared.repository.MenuRepository;
import br.com.edu.foodfusion.shared.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UpdateRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public RestaurantEntity update(long restaurantId, RestaurantEntity restaurantUpdate) {
        RestaurantEntity restaurantFound = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurantFound != null) {
            restaurantFound.setId(restaurantId);
            restaurantFound.setName(restaurantUpdate.getName());
            restaurantFound.setDescription(restaurantUpdate.getDescription());
            restaurantFound.setLogo(restaurantUpdate.getLogo());
            restaurantFound.setAddress(restaurantUpdate.getAddress());
            restaurantFound.setMenus(restaurantUpdate.getMenus());
            restaurantFound.setPhone(restaurantUpdate.getPhone());
            restaurantFound.setType(restaurantUpdate.getType());
            restaurantFound.setUpdatedAt(LocalDateTime.now());
            for (MenuEntity menu : restaurantUpdate.getMenus()) {
                if (menu.getId() == 0) {
                    for (MenuItemEntity menuItem : menu.getItems()) {
                        if (menuItem.getId() == 0) {
                            menuItem.setMenu(menu);
                            menuItemRepository.save(menuItem);
                        }
                    }
                    menu.setRestaurant(restaurantFound);
                    menuRepository.save(menu);
                }
            }

            restaurantFound.setMenus(restaurantUpdate.getMenus());
            return restaurantRepository.save(restaurantFound);
        }

        return null;
    }

    private void addMenus(List<MenuEntity> menus, MenuEntity menu, RestaurantEntity restaurant) {
        menus.add(menu);
        menu.setRestaurant(restaurant);
    }

    private void removeMenus(List<MenuEntity> menus, MenuEntity menu) {
        menus.remove(menu);
        menu.setRestaurant(null);
    }

}
