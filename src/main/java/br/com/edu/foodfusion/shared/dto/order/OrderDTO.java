package br.com.edu.foodfusion.shared.dto.order;

import br.com.edu.foodfusion.shared.database.entity.order.OrderEntity;
import br.com.edu.foodfusion.shared.database.enums.OrderStatusEnum;
import br.com.edu.foodfusion.shared.dto.restaurant.RestaurantDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderDTO {

    private long id;

    private OrderStatusEnum status;

    @NotNull(message = "Establishment is required")
    private RestaurantDTO establishment;

    @NotNull(message = "Customer is required")
    private CustomerDTO customer;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotNull(message = "Items is required")
    @NotEmpty(message = "At least one item must be present")
    private List<OrderItemDTO> items = new ArrayList<>();

    private BigDecimal total;

    public static OrderEntity toEntity(OrderDTO orderDTO){
        return new ModelMapper()
                .map(orderDTO, OrderEntity.class);
    }
}
