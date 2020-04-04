import components.CheckOutModule;
import components.LoginModule;
import components.SharedData;
import components.ShoppingModule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        SharedData sd = new SharedData();
        LoginModule login = new LoginModule(sd);
        ShoppingModule shop = new ShoppingModule(sd);
        CheckOutModule check = new CheckOutModule(sd);
    }
}
