package components;

import entities.Product;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Check out module mainly help user check about the order.
 * - We are assuming user will pay when they receive the order.
 **/

public class CheckOutModule {
    private SharedData sd;

    public CheckOutModule(SharedData sd) throws IOException, ParseException {
        this.sd = sd;
        if (sd.hasCheckout()) {
            this.showConfrimation();
        }
    }

    private void showConfrimation() throws IOException {
        Scanner sc = this.sd.getSc();
        System.out.println("----------Please Confirm Your Order---------");
        for (Product p : this.sd.getCart().getproducts()) {
            System.out.println(String.format("Product ID: %d ------ Product Name: %s ---- Product Price: %.2f", p.getProductID(), p.getProductName(), p.getProductPrice()));
        }
        System.out.println(String.format("----------Total Amount: %.2f---------", this.sd.getCart().showAmount()));

        System.out.println("\nPlease type \"Y\" to confirm and \"N\" back to quit.");

        String cmd = sc.nextLine().toLowerCase();
        while (!cmd.equals("y") && !cmd.equals("n")) {
            System.out.println("Invalid input. Please type in again.");
        }

        if (cmd.equals("y")) {
            System.out.println("You will receive the email about the detailed orders.");
            this.sd.updateOrder();
        } else {
            System.out.println("Successfully logged out.");
        }
    }

}