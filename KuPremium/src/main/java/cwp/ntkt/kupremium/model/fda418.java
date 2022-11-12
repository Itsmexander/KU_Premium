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
    private double benzoic_c;
    private double sorbic_c;
    private boolean benzoic_sorbic_f;
    private double synt_s;
    private double synt_c;
    private boolean synt_f;
    private double sod_s;
    private double sod_c;
    private double sod_f;
    private double potas_s;
    private double potas_c;
    private boolean potas_f;
    private double plate_s;
    private double plate_c;
    private boolean plate_f;
}
