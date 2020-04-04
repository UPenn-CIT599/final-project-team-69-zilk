package entities;

import java.util.ArrayList;

public class Cart {
    private NormalUser user;
    private ArrayList<Product> products = new ArrayList<>();

    public Cart(NormalUser user) {
        this.user = user;
    }

    public void addToCart(Product product) {
        this.products.add(product);
    }

    public void removeFromCart(Product product) {
        this.products.remove(product);
    }

    public boolean hasProduct(Product product) {
        return this.products.contains(product);
    }


    public Double showAmount() {
        Double amount = 0.0;
        for (Product p : this.products) {
            amount += p.getProductPrice();
        }
        return amount;
    }


    public ArrayList<Product> getproducts() {
        return products;
    }

}
