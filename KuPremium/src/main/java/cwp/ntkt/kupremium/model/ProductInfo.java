package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Entity
public class ProductInfo {
    @Id
    private String pID;
    private String productName;
    private String productCategory;
    private double price;
    private String poID;
    private String productDescription;
    private String productAttrib;
    private String productUsageGuideline;
    private String productIngredients;
    private String productQuantity;
    private String productSize;
    private String productVolume;
    private String productWeight;
}
