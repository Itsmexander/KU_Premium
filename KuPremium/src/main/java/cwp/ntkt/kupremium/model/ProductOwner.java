package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class ProductOwner {

    @Id
    @GeneratedValue

    private String poID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String telNo;
    private String email;
    private String address;
}
