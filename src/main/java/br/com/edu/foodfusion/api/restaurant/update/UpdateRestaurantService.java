package br.com.edu.foodfusion.api.restaurant.update;

import br.com.edu.foodfusion.shared.database.entity.contact.info.AddressEntity;
import br.com.edu.foodfusion.shared.database.entity.contact.info.PhoneEntity;
import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuEntity;
import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuItemEntity;
import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
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
            restaurantFound.setAddresses(restaurantUpdate.getAddresses());
            restaurantFound.setMenus(restaurantUpdate.getMenus());
            restaurantFound.setPhones(restaurantUpdate.getPhones());
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

    private void addAddress(List<AddressEntity> addresses, AddressEntity address, RestaurantEntity restaurant) {
        addresses.add(address);
        address.setRestaurant(restaurant);
    }

    private void removeAddress(List<AddressEntity> addresses, AddressEntity address) {
        addresses.remove(address);
        address.setRestaurant(null);
    }

    private void addMenus(List<MenuEntity> menus, MenuEntity menu, RestaurantEntity restaurant) {
        menus.add(menu);
        menu.setRestaurant(restaurant);
    }

    private void removeMenus(List<MenuEntity> menus, MenuEntity menu) {
        menus.remove(menu);
        menu.setRestaurant(null);
    }

    private void addPhones(List<PhoneEntity> phones, PhoneEntity phone, RestaurantEntity restaurant) {
        phones.add(phone);
        phone.setRestaurant(restaurant);
    }

    private void removePhones(List<PhoneEntity> phones, MenuEntity phone) {
        phones.remove(phone);
        phone.setRestaurant(null);
    }

}
