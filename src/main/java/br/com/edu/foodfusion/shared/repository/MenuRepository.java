package br.com.edu.foodfusion.shared.repository;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

}
