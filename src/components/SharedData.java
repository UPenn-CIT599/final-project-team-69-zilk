package components;

import entities.Cart;
import entities.NormalUser;
import entities.Order;
import entities.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class SharedData {

    public Cart cart;
    private Scanner sc = new Scanner(System.in);
    private String productPath = "src/resources/products.txt";
    private String userPath = "src/resources/users.txt";
    private String orderPath = "src/resources/orders.txt";
    private HashMap<Integer, Product> products = new HashMap<>();
    private HashMap<String, NormalUser> users = new HashMap<>();
    private HashMap<Integer, Order> orders = new HashMap<>();
    private NormalUser user;
    private boolean isCheckOut = false;

    private Integer nextUserID = 0;
    private Integer nextOrderID = 0;

    public SharedData() throws FileNotFoundException, ParseException {
    }

    public HashMap<Integer, Product> getProducts() {
    }

    public HashMap<String, NormalUser> getUsers() {
    }

    public Cart getCart() {
    }

    public void setCart(Cart cart) {
    }

    public Scanner getSc() {
    }

    public boolean hasCheckout() {
    }

    public NormalUser getUser() {
    }

    public void setUser(NormalUser user) {
    }

    public Integer getNextUserID() {
    }

    public void setCheckOut(boolean checkOut) {
    }

    public void updateOrder() throws IOException {
        
    }

    public void updateUsers(String username, String password) throws IOException {
        
    }

    private void loadProducts() throws FileNotFoundException {
        
    }

    private void loadUsers() throws FileNotFoundException {
        
    }

    private void loadOrders() throws FileNotFoundException, ParseException {
        
}
