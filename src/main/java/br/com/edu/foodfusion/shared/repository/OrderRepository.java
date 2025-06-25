package br.com.edu.foodfusion.shared.repository;

import br.com.edu.foodfusion.shared.database.entity.order.OrderEntity;
import br.com.edu.foodfusion.shared.database.enums.OrderStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("select o from OrderEntity o where o.status = :status ORDER BY o.id ASC")
    Optional<List<OrderEntity>> findByStatus(@Param("status") OrderStatusEnum status);

}
