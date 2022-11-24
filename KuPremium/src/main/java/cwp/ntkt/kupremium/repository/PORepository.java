package cwp.ntkt.kupremium.repository;


import cwp.ntkt.kupremium.model.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PORepository extends JpaRepository<ProductOwner, String> { //ถามแซนเรื่อง UUID

    // SELECT * FROM User WHERE username = ‘username in parameter’
    ProductOwner findByUsername(String username);
}