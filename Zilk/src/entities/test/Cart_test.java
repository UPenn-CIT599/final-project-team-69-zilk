package src.entities.test;

import src.entities.NormalUser;
import src.entities.Product;
import src.entities.Cart;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * This is the unit test part for Cart.
 **/
class CartTest {

	private NormalUser user = new NormalUser(1, "name", "password");
	private Product product = new Product(1, "product name", 12.0);
	private Cart cart;

	private void resetCart() {
		this.cart = new Cart(user);
	}

	@Test
	void testClassIsCorrect() {
		this.resetCart();
		assertTrue(this.cart.getClass().equals(Cart.class));
	}

	@Test
	void testCanAddProductToCart() {
		this.resetCart();

		int productsSizeBefore = this.cart.getproducts().size();
		this.cart.addToCart(this.product);
		ArrayList<Product> productsAfter = this.cart.getproducts();

		assertTrue(productsAfter.contains(this.product));
		assertEquals(productsAfter.size() - productsSizeBefore, 1);
	}

	@Test
	void testCanRemoveFromCart() {
		this.resetCart();
		this.cart.addToCart(this.product);

		int productsSizeBefore = this.cart.getproducts().size();
		this.cart.removeFromCart(this.product);
		ArrayList<Product> productsAfter = this.cart.getproducts();

		assertFalse(productsAfter.contains(this.product));
		assertEquals(productsAfter.size() - productsSizeBefore, -1);
	}

	@Test
	void testHasProduct() {
		this.resetCart();
		ArrayList<Product> products = this.cart.getproducts();
		this.cart.addToCart(product);
		assertTrue(products.contains(this.product));
	}

	@Test
	void testCanShowAmount() {
		this.resetCart();
		this.cart.addToCart(this.product);

		Double totalAmount = 0.0;
		for (Product p : this.cart.getproducts()) {
			totalAmount += p.getProductPrice();
		}
		assertEquals(this.cart.showAmount(), totalAmount);
	}

	@Test
	void testCartHasUser() {
		this.resetCart();
		assertEquals(this.cart.getUser(), this.user);
	}

}