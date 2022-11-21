package cwp.ntkt.kupremium.model;

public class Cart {

    private ProductInfo products;

    private int quantity;


    public Cart(ProductInfo products, int quantity){
        this.products = products;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return products.toString()+
                "->" + quantity + "}";
    }

    public ProductInfo getCakes(){
        return products;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCakes(ProductInfo cakes) {
        this.products = cakes;
    }

}
