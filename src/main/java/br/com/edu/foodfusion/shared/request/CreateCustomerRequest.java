package br.com.edu.foodfusion.shared.request;

import br.com.edu.foodfusion.shared.dto.contact.info.AddressDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.PhoneDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.email.EmailDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private PhoneDTO phone;
    private EmailDTO email;
    private AddressDTO address;

}
