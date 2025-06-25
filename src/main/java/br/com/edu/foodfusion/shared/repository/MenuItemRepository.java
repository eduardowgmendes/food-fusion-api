package br.com.edu.foodfusion.shared.repository;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long> {

}
