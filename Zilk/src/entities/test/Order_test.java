package src.entities.test;

import src.entities.Order;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the unit test part for Order.
 **/

class OrderTest {

	private Integer orderID = 2;
	private Integer userID = 3;
	private Double amount = 12.0;
	private Date orderTime = new Date();

	private Order order = new Order(this.orderID, this.userID, this.amount, this.orderTime);

	@Test
	void testClassIsCorrect() {
		assertTrue(this.order.getClass().equals(Order.class));
	}

	@Test
	void testCanGetOrderTime() {
		assertEquals(this.order.getOrderTime(), this.orderTime);
	}

	@Test
	void testCanGetOrderID() {
		assertEquals(this.order.getOrderID(), this.orderID);
	}

	@Test
	void testCanGetUserID() {
		assertEquals(this.order.getUserID(), this.userID);
	}

	@Test
	void testCanGetAmount() {
		assertEquals(this.order.getAmount(), this.amount);
	}

}