package entities;

public class Product {
    private Integer productID;
    private String productName;
    private Double productPrice;

    public Product(Integer id, String name, Double price) {
        this.productID = id;
        this.productName = name;
        this.productPrice = price;
    }

    public Integer getProductID() {
        return productID;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }
}
