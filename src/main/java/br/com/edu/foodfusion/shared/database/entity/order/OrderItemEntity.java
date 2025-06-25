package br.com.edu.foodfusion.shared.database.entity.order;


import br.com.edu.foodfusion.shared.dto.order.OrderItemDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "order_items", schema = "orders")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private BigDecimal unitPrice;
    private Integer quantity;

    @ManyToOne
    private OrderEntity order;

    public static OrderItemDTO toDTO(OrderItemEntity orderItem){
        return new ModelMapper()
                .map(orderItem, OrderItemDTO.class);
    }

}
