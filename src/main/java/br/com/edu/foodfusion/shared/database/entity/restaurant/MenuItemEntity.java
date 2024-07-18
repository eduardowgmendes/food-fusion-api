package br.com.edu.foodfusion.shared.database.entity.restaurant;

import br.com.edu.foodfusion.shared.dto.restaurant.MenuItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menus")
public class MenuItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item_name", nullable = false)
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "showcase_pictures", joinColumns = @JoinColumn(name = "menu_id"))
    @Column(name = "showcase_pictures")
    private List<String> showcasePictures;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private MenuEntity menu;

    public static MenuItemDTO toDTO(MenuItemEntity menuItem) {
        return new ModelMapper().map(menuItem, MenuItemDTO.class);
    }
}
