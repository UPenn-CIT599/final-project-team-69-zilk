package src.entities.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {
	
	Product p1 = new Product(1, "bbd", 12.0);

	@Test
	void testProduct() {
		assertEquals(p1.productID, 1);
	}

	@Test
	void testGetProductID() {
		assertEquals(p1.getProductID(), 1);
	}

	@Test
	void testGetProductPrice() {
		assertEquals(p1.getProductPrice(),12.0);
	}

	@Test
	void testGetProductName() {
		assertEquals(p1.getProductName(), "bbd");
	}

}
