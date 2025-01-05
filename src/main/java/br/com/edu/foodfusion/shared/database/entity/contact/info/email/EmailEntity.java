package br.com.edu.foodfusion.shared.database.entity.contact.info.email;

import br.com.edu.foodfusion.shared.database.entity.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.dto.contact.info.email.EmailDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emails")
@EqualsAndHashCode
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    public static EmailDTO toDTO(EmailEntity emailEntity) {
        return new ModelMapper()
                .map(emailEntity, EmailDTO.class);
    }
}
