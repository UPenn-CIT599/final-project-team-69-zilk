package src.entities.test;

import src.entities.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the unit test part for Product.
 **/

class ProductTest {

	private int productID = 1;
	private String productName = "product name";
	private Double productPrice = 12.0;

	private Product product = new Product(this.productID, this.productName, this.productPrice);

	@Test
	void testCanGetProductID() {
		assertEquals(this.product.getProductID(), this.productID);
	}

	@Test
	void testCanGetProductPrice() {
		assertEquals(product.getProductPrice(), this.productPrice);
	}

	@Test
	void testCanGetProductName() {
		assertEquals(product.getProductName(), this.productName);
	}

}
