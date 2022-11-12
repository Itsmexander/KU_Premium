package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class fda356 {
    @Id
    @GeneratedValue
    private String pID;
    private String productName;
    private String r_name;
    private double ph_value_s;
    private double ph_value_c;
    private boolean ph_value_f;
    private double coli_s;
    private double coli_c;
    private boolean coli_f;
    private double yeast_mold_s;
    private double yeast_c;
    private double mold_c;
    private boolean yeast_mold_f;
}