package entities.test;

import entities.Order;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class Order_test {
    private Integer oid = 1;
    private Integer uid = 1;
    private Double amount = 100.0;
    private Date date = new Date();
    private Order order;

    public Order_test(){
        this.order = new Order(this.oid,
                this.uid,
                this.amount,
                this.date);
    }

    @Test(timeout = 10)
    public void testCanGenInstance(){
        assertEquals(this.oid, this.order.getOrderID());
        assertEquals(this.oid, this.order.getUserID());
        assertEquals(this.date, this.order.getOrderTime());
        assertEquals(this.amount, this.order.getAmount());
    }




}
