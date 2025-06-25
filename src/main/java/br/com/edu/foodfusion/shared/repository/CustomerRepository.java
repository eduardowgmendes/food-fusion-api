package br.com.edu.foodfusion.shared.repository;

import br.com.edu.foodfusion.shared.database.entity.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
