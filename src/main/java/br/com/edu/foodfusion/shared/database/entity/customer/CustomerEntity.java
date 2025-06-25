package br.com.edu.foodfusion.shared.database.entity.customer;

import br.com.edu.foodfusion.shared.database.entity.contact.address.AddressEntity;
import br.com.edu.foodfusion.shared.database.entity.contact.phone.PhoneEntity;
import br.com.edu.foodfusion.shared.database.entity.contact.email.EmailEntity;
import br.com.edu.foodfusion.shared.dto.order.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "customers", schema = "orders")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private PhoneEntity phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private EmailEntity email;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String wholeName(){
        return String.format("%s %s", firstName, lastName);
    }

    public static CustomerDTO toDTO(CustomerEntity customer){
        return new ModelMapper()
                .map(customer, CustomerDTO.class);
    }
}
