package entities;

import java.util.Date;

public class Order {
    private Integer orderID;
    private Integer userID;
    private Double amount;
    private Date orderTime;

    public Order(Integer oid, Integer uid, Double amount, Date orderTime) {
        this.orderID = oid;
        this.userID = uid;
        this.amount = amount;
        this.orderTime = orderTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public Integer getUserID() {
        return userID;
    }

    public Double getAmount() { return amount; }
}
