package cwp.ntkt.kupremium.model;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {

    @Id
    private UUID pID;
    private String productName;
    private String productCategory;
    private double price;
    private String poID;
    private String productDescription;
    private String productAttrib;
    private String productUsageGuideline;
    private String productIngredients;
    private int productQuantity;
    private String productSize;
    private String productVolume;
    private String productWeight;

    private String username;
    private String status;

    private List<Cart> cartList = new ArrayList<>();
    public List<Cart> getCartList(){
        return cartList;
    }

    public void add(Cart cartList){
        this.cartList.add(cartList);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public UUID getpID() {
        return pID;
    }

    public void setpID(UUID pID) {
        this.pID = pID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPoID() {
        return poID;
    }

    public void setPoID(String poID) {
        this.poID = poID;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductAttrib() {
        return productAttrib;
    }

    public void setProductAttrib(String productAttrib) {
        this.productAttrib = productAttrib;
    }

    public String getProductUsageGuideline() {
        return productUsageGuideline;
    }

    public void setProductUsageGuideline(String productUsageGuideline) {
        this.productUsageGuideline = productUsageGuideline;
    }

    public String getProductIngredients() {
        return productIngredients;
    }

    public void setProductIngredients(String productIngredients) {
        this.productIngredients = productIngredients;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductVolume() {
        return productVolume;
    }

    public void setProductVolume(String productVolume) {
        this.productVolume = productVolume;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }
}
