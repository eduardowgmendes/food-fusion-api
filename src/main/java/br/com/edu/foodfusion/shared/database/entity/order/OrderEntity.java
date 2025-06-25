package br.com.edu.foodfusion.shared.database.entity.order;

import br.com.edu.foodfusion.shared.database.converter.OrderStatusConverter;
import br.com.edu.foodfusion.shared.database.entity.customer.CustomerEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.database.enums.OrderStatusEnum;
import br.com.edu.foodfusion.shared.dto.order.OrderDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "orders", schema = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "status is mandatory")
    @Enumerated(EnumType.STRING)
    @Convert(converter = OrderStatusConverter.class)
    @Column(nullable = false)
    private OrderStatusEnum status;

    @ManyToOne
    private RestaurantEntity establishment;

    @ManyToOne
    private CustomerEntity customer;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items = new ArrayList<>();

    private BigDecimal total;

    public static OrderDTO toDTO(OrderEntity order) {
        return new ModelMapper()
                .map(order, OrderDTO.class);
    }

}
