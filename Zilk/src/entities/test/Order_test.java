package src.entities.test;

import src.entities.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the unit test part for Order.
 **/

class OrderTest {

	Date d1 = new Date();
	Order o1 = new Order(2, 3, 12.0, d1);

    @Test
    void testGetOrderTime() {
        assertEquals(o1.getOrderTime(), d1);
    }

    @Test
    void testGetOrderID() {
        assertEquals(o1.getOrderID(), 2);
    }

    @Test
    void testGetUserID() {
        assertEquals(o1.getUserID(), 3);
    }

    @Test
    void testGetAmount() {
        assertEquals(o1.getAmount(), 12.0);
    }

}