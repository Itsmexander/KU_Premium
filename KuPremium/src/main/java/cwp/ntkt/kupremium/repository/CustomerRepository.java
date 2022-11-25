package cwp.ntkt.kupremium.repository;


import cwp.ntkt.kupremium.model.Customer;
import cwp.ntkt.kupremium.model.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    // SELECT * FROM User WHERE username = ‘username in parameter’
    Customer findByUsername(String username);
}