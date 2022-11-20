package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class RDI {

    @Id
    @GeneratedValue

    private String researcherID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String telNo;
    private String email;
    private String rank;
}
