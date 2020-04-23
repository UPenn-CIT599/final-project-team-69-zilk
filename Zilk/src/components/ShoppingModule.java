package src.components;

import src.Common.Utilities;
import src.entities.Cart;
import src.entities.Logo;
import src.entities.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The shopping module mainly controls the part to interact with shopping cart.
 * 1. After login, user can see all the logo and products.
 * 2. User can add product to cart or remove from cart.
 * 3. User can router to different components.
 **/


public class ShoppingModule {
    private SharedData sd;
    private Cart cart;

    public ShoppingModule(SharedData sd) throws FileNotFoundException {
        this.sd = sd;
        this.cart = new Cart(this.sd.getUser());
        this.showLogo();
        this.showProducts();
        this.switcher();
        this.sd.setCart(this.cart);
    }

    /**
     * To show logo of the website
     */
    private void showLogo() {
        System.out.println("----------------------------------------");
        Logo.genLogo();
        System.out.println("----------------------------------------");
    }

    /**
     * To show the information of each product
     */
    private void showProducts() {
        for (Integer pid : this.sd.getProducts().keySet()) {
            Product p = this.sd.getProducts().get(pid);
            System.out.println(String.format("Product ID: %d ------ Product Name: %s ---- Product Price: %.2f", p.getProductID(), p.getProductName(), p.getProductPrice()));
        }
        Utilities.singleLine();
    }

    /**
     * To display instruction and options for further actions
     */
    private void switcher() {
        Utilities.addLines("Type any key to show guidance.");
        Scanner sc = this.sd.getSc();
        String cmd = sc.nextLine();
        while (!cmd.equals("q")) {
            this.showGuidance();
            cmd = sc.nextLine();

            if (cmd.equals("Check")) {
                this.sd.setCheckOut(true);
                return;
            }

            try {
                int pid = Integer.parseInt(cmd);
                if (pid >= 0) {
                    this.addToCart(pid);
                } else {
                    this.removeFromCart(-pid);
                }
            } catch (NumberFormatException ignored) {
            }
        }
        Utilities.addLines("Wish you will come again !");
    }
    
    /**
     * To display instruction
     */
    private void showGuidance() {
        String line1 = "-Type number to add to cart. e.g. 1\n";
        String line2 = "-Type \"Check\" to check out.\n";
        String line3 = "-Type negative number to remove product.\n";
        String line4 = "-Type \"q\" to quit.";
        System.out.println(line1 + line2 + line3 + line4);
    }
    
    /**
     * To add a product to the cart
     * @param productID the ID that identifies a product
     */
    private void addToCart(Integer productID) {
        if (this.sd.getProducts().containsKey(productID)) {
            Product temp = this.sd.getProducts().get(productID);
            this.cart.addToCart(temp);
            Utilities.addLines(String.format("Product %d has been added.", temp.getProductID()));
        } else {
            Utilities.addLines("This is not an valid product ID.");
        }
    }
    
    /**
     * To remove a product from the cart
     * @param productID the ID that identifies a product
     */
    private void removeFromCart(Integer productID) {
        if (this.cart.hasProduct(this.sd.getProducts().get(productID))) {
            this.cart.removeFromCart(this.sd.getProducts().get(productID));
            Utilities.addLines(String.format("Product %d has been removed.", productID));
        } else {
            Utilities.addLines("You don't have this product in cart.");
        }
    }

}


