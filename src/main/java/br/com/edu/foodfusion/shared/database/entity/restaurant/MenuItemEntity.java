package br.com.edu.foodfusion.shared.database.entity.restaurant;

import br.com.edu.foodfusion.shared.database.entity.picture.ShowcasePictureEntity;
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
@Entity(name = "menu_item")
@Table(name = "menu_items")
public class MenuItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item_name", nullable = false)
    private String name;

    @Column(name = "item_description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "menuItem", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(name = "showcase_pictures")
    private List<ShowcasePictureEntity> showcasePictures;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

    public static MenuItemDTO toDTO(MenuItemEntity menuItem) {
        return new ModelMapper().map(menuItem, MenuItemDTO.class);
    }
}
