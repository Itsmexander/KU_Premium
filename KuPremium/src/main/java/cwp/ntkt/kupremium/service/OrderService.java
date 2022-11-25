package cwp.ntkt.kupremium.service;

import cwp.ntkt.kupremium.model.Cart;
import cwp.ntkt.kupremium.model.Order;
import cwp.ntkt.kupremium.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.lang.Integer.parseInt;

@Service
public class OrderService {

//    @Autowired
//    private OrderRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CartService cartService;
    @Autowired
    private PODetailServiceImp userService;
    private List<Order> cart = new ArrayList<>();

    public List<Order> getAll(){
        String url = "http://localhost:8090/order";
        ResponseEntity<Order[]> response = restTemplate.getForEntity(url, Order[].class);
        Order[] cakes = response.getBody();
        return Arrays.asList(cakes);
    }

    public void addOrder(Order cake){
        String url = "http://localhost:8090/order";
        Order cakesOrder = new Order();
        cakesOrder = cake;
        cakesOrder.setUsername(userService.getUser().getUsername());
        cakesOrder.setProductName(cartService.getCart().toString());
        cakesOrder.setStatus("Underpayment");
        restTemplate.postForObject(url, cakesOrder, Order.class);
    }

    public void OrderConfig(){
        cart = this.getAll();
        for(int i = 0; i < this.getAll().size(); i++){
            String hee = new String("");
            hee = this.getAll().get(i).getProductName();
            hee = hee.replace("[", "").replace("]","");
            hee = hee.replace("{","[").replace("}","]");
            hee = hee.replace("[","").replace("]","");
            String[] split = hee.split(",");
            List<String> list = Arrays.asList(split);
            for (int j = 0;j < list.size();j++){
                String hee2 =list.get(j);
                split = list.get(j).trim().split("->");
                List<String> list1 = Arrays.asList(split);
                for (int k =0;k<list1.size();k++){
//                    System.out.println(list1.get(k).trim());
                }
                ProductInfo productInfo = new ProductInfo(UUID.fromString(list1.get(0)),(list1.get(1)),(list1.get(2))
                        ,Double.parseDouble(list1.get(3)),(list1.get(4)),(list1.get(5)),(list1.get(6)),(list1.get(7)),
                        (list1.get(8)),parseInt(list1.get(9)),(list1.get(10)),(list1.get(11)),(list1.get(12)));
                cart.get(i).add(new Cart(productInfo,parseInt(list1.get(5))));
            }
        }
    }
    public List<Order> getDummy(String name){ //getall
        this.OrderConfig();
        List<Order> cart2 = new ArrayList<>();
        if (name.equals("PO")){
            return cart;
        }
        else {
            for (int i =0; i<cart.size();i++){
                if (name.equals(cart.get(i).getUsername())){
                    cart2.add(cart.get(i));
                }
            }
        }
        return cart2;
    }
    public Order getDummyByID(UUID id){
        Order order = new Order();
        for (int i=0;i < cart.size();i++){
            if (cart.get(i).getpID().equals(id)){
                order = cart.get(i);
                return order;
            }
        }
        return order;
    }

    public Order getOneById(UUID id) {
        String url = "http://localhost:8090/order/" + id;
        ResponseEntity<Order> response =
                restTemplate.getForEntity(url, Order.class);
        Order products = response.getBody();
        return products;
    }
    public void update(Order products) {
        String url = "http://localhost:8090/order/" + products.getpID();
        restTemplate.put(url, products, Order.class);
    }
    public void delete(Order cakes) {
        String url = "http://localhost:8090/order/" + cakes.getpID();
        restTemplate.delete(url, cakes, Order.class);
    }
}
