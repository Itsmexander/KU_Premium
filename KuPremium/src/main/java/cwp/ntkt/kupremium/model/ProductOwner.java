package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class ProductOwner extends User{
    private String POID;



}
