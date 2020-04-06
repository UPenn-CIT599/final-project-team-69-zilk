package entities;

import java.util.ArrayList;

/**
 * Cart represent the current user's cart. After user login, they can add or remove
 * products to their cart and understand current accumulative amount.
 */
public class Cart {
    private NormalUser user;
    private ArrayList<Product> products = new ArrayList<>();

    public Cart(NormalUser user) {
        this.user = user;
    }

    /**
     * Add to cart.*
     */
    public void addToCart(Product product) {
        this.products.add(product);
    }

    /**
     * Remove from cart.
     **/
    public void removeFromCart(Product product) {
        this.products.remove(product);
    }

    /**
     * Is cart has product.
     **/
    public boolean hasProduct(Product product) {
        return this.products.contains(product);
    }

    /**
     * Total value sum of shopping cart.
     **/
    public Double showAmount() {
        Double amount = 0.0;
        for (Product p : this.products) {
            amount += p.getProductPrice();
        }
        return amount;
    }

    /**
     * Get all products from the shopping cart.
     **/
    public ArrayList<Product> getproducts() {
        return products;
    }

}
