package br.com.edu.foodfusion.api.customer.controller;

import br.com.edu.foodfusion.api.customer.service.CustomerService;
import br.com.edu.foodfusion.shared.database.entity.customer.CustomerEntity;
import br.com.edu.foodfusion.shared.dto.contact.info.AddressDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.PhoneDTO;
import br.com.edu.foodfusion.shared.dto.contact.info.email.EmailDTO;
import br.com.edu.foodfusion.shared.dto.order.CustomerDTO;
import br.com.edu.foodfusion.shared.request.CreateCustomerRequest;
import br.com.edu.foodfusion.shared.response.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<DefaultResponse<List<CustomerDTO>>> findAll() {
        List<CustomerEntity> allCustomersFound = customerService.findAll();

        if (allCustomersFound.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(DefaultResponse.create(false, "No customers found", null));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(DefaultResponse.create(true, "These are all the customers we found: " + allCustomersFound.size(), allCustomersFound.stream()
                        .map(CustomerEntity::toDTO)
                        .collect(Collectors.toList())));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<DefaultResponse<CustomerDTO>> findById(@PathVariable(name = "customerId") long customerId) {
        CustomerEntity customerFound = customerService.findById(customerId);

        if (customerFound == null)
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "No customer found with given id: " + customerId, null));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(DefaultResponse.create(true, "We found this customer", CustomerEntity.toDTO(customerFound)));
    }

    @PostMapping("/create")
    public ResponseEntity<DefaultResponse<CustomerDTO>> create(@RequestBody CreateCustomerRequest request) {

        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        PhoneDTO phone = request.getPhone();
        EmailDTO email = request.getEmail();
        AddressDTO address = request.getAddress();

        CustomerEntity customer = new CustomerEntity();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(PhoneDTO.toPhoneEntity(phone));
        customer.setEmail(EmailDTO.toEmailEntity(email));
        customer.setAddress(AddressDTO.toAddressEntity(address));

        CustomerEntity customerCreated = customerService.create(customer);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(DefaultResponse.create(true, "New customer has been created.", CustomerEntity.toDTO(customerCreated)));
    }
}
