package entities.test;

import entities.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the unit test part for Product.
 **/

class ProductTest {

    Product p1 = new Product(1, "bbd", 12.0);

    @Test
    void testGetProductID() {
        assertEquals(p1.getProductID(), 1);
    }

    @Test
    void testGetProductPrice() {
        assertEquals(p1.getProductPrice(), 12.0);
    }

    @Test
    void testGetProductName() {
        assertEquals(p1.getProductName(), "bbd");
    }

}
