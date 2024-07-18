package br.com.edu.foodfusion.shared.database.entity.restaurant;

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
@Entity
@Table(name = "menus")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "menu_name", nullable = false, length = 256)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "menu")
    private List<MenuItemEntity> items;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;

    public static MenuDTO toDTO(MenuEntity menu) {
        return new ModelMapper()
                .map(menu, MenuDTO.class);
    }

}
