package entities;

import java.util.Date;

/**
 * This construct an order object to keep order information
 *
 * @author Karen
 */
public class Order {
    private Integer orderID;
    private Integer userID;
    private Double amount;
    private Date orderTime;

    /**
     * Constructor to obtain order information
     *
     * @param oid
     * @param uid
     * @param amount
     * @param orderTime
     */
    public Order(Integer oid, Integer uid, Double amount, Date orderTime) {
        this.orderID = oid;
        this.userID = uid;
        this.amount = amount;
        this.orderTime = orderTime;
    }

    /**
     * Method to retrieve order time
     *
     * @return order time
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * Method to retrieve order iD
     *
     * @return order ID for the order
     */
    public Integer getOrderID() {
        return orderID;
    }

    /**
     * Method to retrieve user ID
     *
     * @return user ID for the order
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Method to retrieve the amount for the order
     *
     * @return amount for the order
     */
    public Double getAmount() {
        return amount;
    }
}
