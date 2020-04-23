package src.entities.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import src.entities.Cart;
import src.entities.NormalUser;
import src.entities.Product;

//import static org.junit.jupiter.api.Assertions.fail;

/**
 * This is the unit test part for Cart.
 **/
class CartTest {

    Product p1 = new Product(1, "a1b1", 12.50);
    Product p2 = new Product(3, "h5b5", 13.50);
    
    NormalUser u1 = new NormalUser(0, "karen", "123");
    
    Cart c1 = new Cart(u1);
    

    @Test
    void testHasProduct() {
    	
    	c1.addToCart(p1);
    	c1.addToCart(p2);
    	assertTrue(c1.hasProduct(p1));
    }

	@Test
    void testShowAmount() {
		
		c1.addToCart(p1);
    	c1.addToCart(p2);
		assertEquals(c1.showAmount(), 26.0);
        
    }

}