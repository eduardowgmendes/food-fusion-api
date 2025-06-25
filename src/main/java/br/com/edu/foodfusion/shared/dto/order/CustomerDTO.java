package br.com.edu.foodfusion.shared.dto.order;

import br.com.edu.foodfusion.shared.database.entity.customer.CustomerEntity;
import br.com.edu.foodfusion.shared.dto.contact.info.AddressDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.PhoneDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.email.EmailDTO;
import lombok.*;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CustomerDTO {

    private long id;
    private String firstName;
    private String lastName;
    private PhoneDTO phone;
    private EmailDTO email;
    private AddressDTO address;

    public String wholeName(){return String.format("%s %s", firstName, lastName);}

    public static CustomerEntity toEntity(CustomerDTO customerDTO){
        return new ModelMapper()
                .map(customerDTO, CustomerEntity.class);
    }

}
