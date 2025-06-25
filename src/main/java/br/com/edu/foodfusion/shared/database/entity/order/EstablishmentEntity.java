package br.com.edu.foodfusion.shared.database.entity.order;

import br.com.edu.foodfusion.shared.database.enums.EstablishmentTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "establishments", schema = "orders")
public class EstablishmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private EstablishmentTypeEnum type;
}
