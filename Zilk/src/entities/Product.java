package src.entities;

/**
 * This constructs a product with different values
 *
 * @author Karen
 */
public class Product {
	private Integer productID;
	private String productName;
	private Double productPrice;

	/**
	 * A constructor to set up different values for a product
	 *
	 * @param id    product's id
	 * @param name  product's name
	 * @param price product's price
	 */
	public Product(Integer id, String name, Double price) {
		this.productID = id;
		this.productName = name;
		this.productPrice = price;
	}

	/**
	 * A method to retrieve product ID
	 *
	 * @return product's product ID
	 */
	public Integer getProductID() {
		return productID;
	}

	/**
	 * A method to retrieve product price
	 *
	 * @return product's price
	 */
	public Double getProductPrice() {
		return productPrice;
	}

	/**
	 * A method to retrieve product name
	 *
	 * @return product's name
	 */
	public String getProductName() {
		return productName;
	}
}
