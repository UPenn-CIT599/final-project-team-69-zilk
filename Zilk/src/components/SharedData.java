package src.components;

import src.entities.Cart;
import src.entities.NormalUser;
import src.entities.Order;
import src.entities.Product;

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


/**
 * This is the integrated data layer to cache all relevant data between different
 * components. All different components will share this data. Generally speaking,
 * it has several different parts.
 * 1. Preloading all relevant data. e.g. users, orders, products
 * 2. Provide data access to other components so that other component can gain data
 * from related methods.
 **/
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
        this.loadProducts();
        this.loadUsers();
        this.loadOrders();
    }
    
    /**
     * To create a hashmap for product list
     * @return product list
     */
    public HashMap<Integer, Product> getProducts() {
        return products;
    }
    
    /**
     * To create a hashmap for user list
     * @return user list
     */
    public HashMap<String, NormalUser> getUsers() {
        return users;
    }
    
    /**
     * @return the cart
     */
    public Cart getCart() {
        return cart;
    }
    
    /**
     * set the cart to be the input cart
     * @param cart
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    /**
     * @return scanner
     */
    public Scanner getSc() {
        return sc;
    }
    
    /**
     * @return the status of checkout
     */
    public boolean hasCheckout() {
        return this.isCheckOut;
    }
    
    /**
     * @return user
     */
    public NormalUser getUser() {
        return this.user;
    }
    
    /**
     * Set user to be the input user 
     * @param user
     */
    public void setUser(NormalUser user) {
        this.user = user;
    }
    
    /**
     * @return the next userID
     */
    public Integer getNextUserID() {
        return nextUserID;
    }

    /**
     * Set the check out status as the input status
     * @param checkOut
     */
    public void setCheckOut(boolean checkOut) {
        isCheckOut = checkOut;
    }
    
    /**
     * Record the order
     * @throws IOException
     */
    public void updateOrder() throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        String newOrder = String.format("\r\n%d,%s,%.2f,%s",
                this.nextOrderID,
                this.user.getUserID(),
                this.cart.showAmount(),
                dateFormat.format(date));

        Path path = Paths.get(this.orderPath);
        Files.write(path, newOrder.getBytes(), StandardOpenOption.APPEND);
    }

    /**
     * Record the user
     * @param username
     * @param password
     * @throws IOException
     */
    public void updateUsers(String username, String password) throws IOException {
        String newUser = String.format("\r\n%d %s %s", this.nextUserID, username, password);
        Path path = Paths.get(this.userPath);
        Files.write(path, newUser.getBytes(), StandardOpenOption.APPEND);
    }

    /**
     * Load products from the product list
     * @throws FileNotFoundException
     */
    private void loadProducts() throws FileNotFoundException {
        Scanner myReader = new Scanner(new File(productPath));
        while (myReader.hasNextLine()) {
            String[] line = myReader.nextLine().split(",");
            Product temp = new Product(Integer.parseInt(line[0]), line[1], Double.parseDouble(line[2]));
            this.products.put(temp.getProductID(), temp);
        }
        myReader.close();
    }

    /**
     * Load users from the user list
     * @throws FileNotFoundException
     */
    private void loadUsers() throws FileNotFoundException {
        Scanner myReader = new Scanner(new File(userPath));
        while (myReader.hasNextLine()) {
            String[] line = myReader.nextLine().split(" ");
            int userID = Integer.parseInt(line[0]);
            this.nextUserID = Math.max(userID, nextUserID);
            String username = line[1], password = line[2];
            NormalUser user = new NormalUser(userID, username, password);
            this.users.put(username, user);
        }
        this.nextUserID++;
        myReader.close();
    }
    
    /**
     * Load orders from the order list
     * @throws FileNotFoundException
     * @throws ParseException
     */
    private void loadOrders() throws FileNotFoundException, ParseException {
        Scanner myReader = new Scanner(new File(orderPath));
        while (myReader.hasNextLine()) {
            String[] line = myReader.nextLine().split(",");
            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(line[3]);
            Order temp = new Order(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Double.parseDouble(line[2]), date);
            this.orders.put(temp.getOrderID(), temp);
            nextOrderID = Math.max(nextOrderID, temp.getOrderID());
        }
        nextOrderID++;
        myReader.close();
    }
}
