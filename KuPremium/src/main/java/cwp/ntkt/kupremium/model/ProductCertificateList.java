package cwp.ntkt.kupremium.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;


public class ProductCertificateList{

    public ArrayList<ProductCertificate> productCertificateList;

    public ProductCertificateList() {
        productCertificateList = new ArrayList<>();
    }

    public void addList(ProductCertificate productCertificate){productCertificateList.add(productCertificate);}
}
