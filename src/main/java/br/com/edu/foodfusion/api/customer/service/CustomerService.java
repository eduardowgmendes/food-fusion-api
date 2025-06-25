package br.com.edu.foodfusion.api.customer.service;

import br.com.edu.foodfusion.shared.database.entity.customer.CustomerEntity;
import br.com.edu.foodfusion.shared.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    public CustomerEntity findById(long customerId) {
        return customerRepository
                .findById(customerId)
                .orElse(null);
    }

    public CustomerEntity create(CustomerEntity customer) {
        if (customer == null) return null;
        customer.setCreatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

}
