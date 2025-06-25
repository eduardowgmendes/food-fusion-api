package br.com.edu.foodfusion.shared.database.entity.order;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.RestaurantEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "products", schema = "orders")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private BigDecimal price;

    @ManyToOne
    private RestaurantEntity establishment;

    private Boolean available;

}
