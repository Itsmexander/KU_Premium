package cwp.ntkt.kupremium.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@Entity
public class ProductPicList {
    @Id
    public ArrayList<ProductPic> productPicList;

    public ProductPicList() {
        productPicList = new ArrayList<>();
    }

    public void addList(ProductPic productPic){productPicList.add(productPic);}
}
