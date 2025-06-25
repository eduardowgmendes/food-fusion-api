package br.com.edu.foodfusion.shared.database.entity.establishment.restaurant;

import br.com.edu.foodfusion.shared.dto.restaurant.MenuDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "menu")
@Table(name = "menus", schema = "establishments")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "menu_name", nullable = false, length = 256)
    private String name;

    @Column(name = "menu_description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MenuItemEntity> items;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    public static MenuDTO toDTO(MenuEntity menu) {
        return new ModelMapper()
                .map(menu, MenuDTO.class);
    }

}
