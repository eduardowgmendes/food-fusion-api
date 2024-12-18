package br.com.edu.foodfusion.shared.database.entity.picture;

import br.com.edu.foodfusion.shared.database.entity.restaurant.MenuItemEntity;
import br.com.edu.foodfusion.shared.dto.picture.ShowcasePictureDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "showcase_picture")
@Table(name = "showcase_pictures")
public class ShowcasePictureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "base64", columnDefinition = "TEXT")
    private String base64;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItemEntity menuItem;

    public static ShowcasePictureDTO toDTO(ShowcasePictureEntity showcasePicture) {
        return new ModelMapper().map(showcasePicture, ShowcasePictureDTO.class);
    }
}
