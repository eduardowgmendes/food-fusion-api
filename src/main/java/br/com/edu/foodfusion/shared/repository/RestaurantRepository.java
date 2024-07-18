package br.com.edu.foodfusion.shared.repository;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    @Query("select r from RestaurantEntity r where lower(r.name) like lower(concat('%', :name, '%')) and r.deleted = false ORDER BY r.id ASC")
    Optional<List<RestaurantEntity>> findByNameLike(@Param("name") String name);

    @Query("select r from RestaurantEntity r where lower(r.type) like lower(concat('%', :type, '%')) and r.deleted = false ORDER BY r.id ASC")
    Optional<List<RestaurantEntity>> findByType(@Param("type") String type);

    @Query("select r from RestaurantEntity r where r.deleted = false ORDER BY r.id ASC")
    Optional<List<RestaurantEntity>> findAllNotErased();

}
