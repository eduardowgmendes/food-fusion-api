package br.com.edu.foodfusion.shared.database.entity.contact.address;

import br.com.edu.foodfusion.shared.database.converter.AddressTypeConverter;
import br.com.edu.foodfusion.shared.database.enums.AddressTypeEnum;
import br.com.edu.foodfusion.shared.dto.contact.info.AddressDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "addresses", schema = "contacts")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "local_number")
    private String localNumber;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zipcode")
    private String zipcode;

    @Convert(converter = AddressTypeConverter.class)
    @Enumerated(value = EnumType.STRING)
    private AddressTypeEnum type;

    public static AddressDTO toDTO(AddressEntity address) {
        return new ModelMapper()
                .map(address, AddressDTO.class);
    }

}
