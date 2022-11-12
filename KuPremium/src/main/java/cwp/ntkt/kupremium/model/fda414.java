package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class fda414 {
    @Id
    @GeneratedValue
    private String pID;
    private String productName;
    private String r_name;
    private double lead_s;
    private double lead_c;
    private boolean lead_f;
}
