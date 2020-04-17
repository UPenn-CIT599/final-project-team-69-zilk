package src;

import src.components.CheckOutModule;
import src.components.LoginModule;
import src.components.SharedData;
import src.components.ShoppingModule;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        SharedData sd = new SharedData();
        LoginModule login = new LoginModule(sd);
        ShoppingModule shop = new ShoppingModule(sd);
        CheckOutModule check = new CheckOutModule(sd);
    }
}
