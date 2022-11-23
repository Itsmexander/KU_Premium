package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
public class ProductPicList {
    public ArrayList<ProductPic> productPicList;

    public ProductPicList() {
        productPicList = new ArrayList<>();
    }

    public void addList(ProductPic productPic){productPicList.add(productPic);}
}
