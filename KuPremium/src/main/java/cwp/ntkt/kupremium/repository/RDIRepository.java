package cwp.ntkt.kupremium.repository;


import cwp.ntkt.kupremium.model.RDI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RDIRepository extends JpaRepository<RDI, UUID> {

    // SELECT * FROM User WHERE username = ‘username in parameter’
    RDI findByUsername(String username);
}