package cwp.ntkt.kupremium.repository;


import cwp.ntkt.kupremium.model.Employee;
import cwp.ntkt.kupremium.model.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    // SELECT * FROM User WHERE username = ‘username in parameter’
    Employee findByUsername(String username);
}