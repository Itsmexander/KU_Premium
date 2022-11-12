package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class fda418 {
    @Id
    @GeneratedValue

    private String pID;
    private String productName;
    private String r_name;
    private double sum_benzoic_sorbic;
}
