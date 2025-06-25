package br.com.edu.foodfusion.shared.database.entity.contact.phone;

import br.com.edu.foodfusion.shared.dto.contact.info.PhoneDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phones", schema = "contacts")
@EqualsAndHashCode
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "prefix", nullable = false, length = 3)
    private String prefix;

    @Column(name = "phone_number", nullable = false, length = 16)
    private String phoneNumber;

    public static PhoneDTO toDTO(PhoneEntity phone) {
        return new ModelMapper()
                .map(phone, PhoneDTO.class);
    }

}
