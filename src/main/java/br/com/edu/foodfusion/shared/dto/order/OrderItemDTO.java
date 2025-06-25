package br.com.edu.foodfusion.shared.dto.order;

import br.com.edu.foodfusion.shared.database.entity.order.OrderItemEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderItemDTO {

    private long id;

    @NotNull(message = "Title is required.")
    private String title;

    @NotNull(message = "Price is required.")
    private BigDecimal price;

    @NotNull(message = "Quantity is required.")
    private Integer quantity;

    public static OrderItemEntity toEntity(OrderItemDTO orderItemDTO) {
        return new ModelMapper()
                .map(orderItemDTO, OrderItemEntity.class);
    }
}
