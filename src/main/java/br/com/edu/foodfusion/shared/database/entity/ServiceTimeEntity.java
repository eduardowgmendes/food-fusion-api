package br.com.edu.foodfusion.shared.database.entity;

import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.dto.restaurant.ServiceTimeDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_times", schema = "establishments")
public class ServiceTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "opens_at", nullable = false)
    @Temporal(value = TemporalType.TIME)
    private LocalTime opensAt;

    @Column(name = "closes_at", nullable = false)
    @Temporal(value = TemporalType.TIME)
    private LocalTime closesAt;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;

    public static ServiceTimeDTO toServiceTimeDTO(ServiceTimeEntity serviceTimeEntity) {
        return new ModelMapper()
                .map(serviceTimeEntity, ServiceTimeDTO.class);
    }

}
