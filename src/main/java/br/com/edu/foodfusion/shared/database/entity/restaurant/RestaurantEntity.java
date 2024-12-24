package br.com.edu.foodfusion.shared.database.entity.restaurant;

import br.com.edu.foodfusion.shared.database.converter.CuisineTypeConverter;
import br.com.edu.foodfusion.shared.database.entity.contact.info.AddressEntity;
import br.com.edu.foodfusion.shared.database.entity.contact.info.PhoneEntity;
import br.com.edu.foodfusion.shared.database.enums.CuisineType;
import br.com.edu.foodfusion.shared.dto.restaurant.RestaurantDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "restaurant_name", nullable = false, length = 256)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "logo", columnDefinition = "TEXT")
    private String logo;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AddressEntity> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PhoneEntity> phones = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MenuEntity> menus = new ArrayList<>();

    @NotNull(message = "type is mandatory")
    @Enumerated(value = EnumType.STRING)
    @Convert(converter = CuisineTypeConverter.class)
    @Column(nullable = false)
    private CuisineType type;

    @Column(name = "created_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime deletedAt;

    @Column(name = "is_deleted")
    private boolean deleted;

    public static RestaurantDTO toDTO(RestaurantEntity restaurant) {
        return new ModelMapper()
                .map(restaurant, RestaurantDTO.class);
    }

}
