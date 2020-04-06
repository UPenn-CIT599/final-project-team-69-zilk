package src.entities.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {
	
	Order o1 = new Order(2,3,12.0,04/04/2020);

	@Test
	void testOrder() {
		assertEquals(o1.orderID, 2);
	}

	@Test
	void testGetOrderTime() {
		assertEquals(o1.getOrderTime(),04/04/2020);
	}

	@Test
	void testGetOrderID() {
		assertEquals(o1.getOrderID(),2);
	}

	@Test
	void testGetUserID() {
		assertEquals(o1.getUserID(),3);
	}

	@Test
	void testGetAmount() {
		assertEquals(o1.getAmount(),12.0);
	}

}