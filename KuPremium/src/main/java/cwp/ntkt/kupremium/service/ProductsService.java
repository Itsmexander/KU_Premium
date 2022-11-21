package cwp.ntkt.kupremium.service;

import cwp.ntkt.kupremium.model.ProductInfo;
import cwp.ntkt.kupremium.model.ProductOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ProductsService {
    @Autowired
    private RestTemplate restTemplate;

    public List<ProductInfo> getAll(){
        String url = "http://localhost:8090/cakes";
        ResponseEntity<ProductInfo[]> response = restTemplate.getForEntity(url, ProductInfo[].class);
        ProductInfo[] cakes = response.getBody();
        return Arrays.asList(cakes);
    }

//    public List<Cart> getOrder(){
//        String url = "http://localhost:8090/cakes";
//        ResponseEntity<Cakes[]> response = restTemplate.getForEntity(url, Cakes[].class);
//        Cakes[] cakes = response.getBody();
//        ArrayList orders = new ArrayList();
//        for(int i = 0 ; i < cakes.length; i++){
//            orders.add(new Cart(cakes[i], 0));
//        }
//        return orders;
//    }

    public void addCakes(ProductInfo products){
        String url = "http://localhost:8090/cakes";
        restTemplate.postForObject(url, products, ProductInfo.class );
    }

    public ProductInfo getOneById(UUID id){
        String url = "http://localhost:8090/cakes/" + id;
        ResponseEntity<ProductInfo> response =
                restTemplate.getForEntity(url, ProductInfo.class);
        ProductInfo products = response.getBody();
        return products;
    }
    public void update(ProductInfo products){
        String url = "http://localhost:8090/cakes/" + products.getpID();
        restTemplate.put(url, products, ProductInfo.class);
    }

//    public void updateCart(List<Cart> cart){
//        for (int i = 0 ; i < cart.size(); i++){
//            Cakes update = this.getOneById(cart.get(i).getCakes().getId());
//            update.setAmount(update.getAmount()-cart.get(i).getQuantity());
//            String url = "http://localhost:8090/cakes/" + update.getId();
//            if(update.getAmount() != 0){
//                restTemplate.put(url, update, Cakes.class);
//            }
//            else {
//                restTemplate.delete(url,update,Cakes.class);
//            }
//        }
//    }
}
