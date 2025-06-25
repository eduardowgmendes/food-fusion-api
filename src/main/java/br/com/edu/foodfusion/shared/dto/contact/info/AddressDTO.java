package br.com.edu.foodfusion.shared.dto.contact.info;

import br.com.edu.foodfusion.shared.database.entity.contact.address.AddressEntity;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressDTO {

    private String street;
    private String localNumber;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public static AddressEntity toAddressEntity(AddressDTO addressDTO) {
        return new ModelMapper()
                .map(addressDTO, AddressEntity.class);
    }
}
