package br.com.edu.foodfusion.shared.database.entity.contact.email;

import br.com.edu.foodfusion.shared.dto.contact.info.email.EmailDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emails", schema = "contacts")
@EqualsAndHashCode
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    public static EmailDTO toDTO(EmailEntity emailEntity) {
        return new ModelMapper()
                .map(emailEntity, EmailDTO.class);
    }
}
