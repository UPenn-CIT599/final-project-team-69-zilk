package components;

import Common.Utilities;
import entities.Cart;
import entities.Logo;
import entities.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

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

    private void showLogo() {
        System.out.println("----------------------------------------");
        Logo.genLogo();
        System.out.println("----------------------------------------");
    }

    private void showProducts() {
        for (Integer pid : this.sd.getProducts().keySet()) {
            Product p = this.sd.getProducts().get(pid);
            System.out.println(String.format("Product ID: %d ------ Product Name: %s ---- Product Price: %.2f", p.getProductID(), p.getProductName(), p.getProductPrice()));
        }
        Utilities.singleLine();
    }

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

    private void showGuidance() {
        String line1 = "-Type number to add to cart. e.g. 1\n";
        String line2 = "-Type \"Check\" to check out.\n";
        String line3 = "-Type negative number to remove product.\n";
        String line4 = "-Type \"q\" to quit.";
        System.out.println(line1 + line2 + line3 + line4);
    }

    private void addToCart(Integer productID) {
        if (this.sd.getProducts().containsKey(productID)) {
            Product temp = this.sd.getProducts().get(productID);
            this.cart.addToCart(temp);
            Utilities.addLines(String.format("Product %d has been added.", temp.getProductID()));
        } else {
            Utilities.addLines("This is not an valid product ID.");
        }
    }

    private void removeFromCart(Integer productID) {
        if (this.cart.hasProduct(this.sd.getProducts().get(productID))) {
            this.cart.removeFromCart(this.sd.getProducts().get(productID));
            Utilities.addLines(String.format("Product %d has been removed.", productID));
        } else {
            Utilities.addLines("You don't have this product in cart.");
        }
    }

}


