package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Shelf.GET_ALL_SHELVES_QUERY_NAME, query="SELECT s FROM Shelf s")
@NamedQuery(name=Shelf.GET_SHELVES_BY_PRODUCT_ID_QUERY_NAME, query="SELECT s FROM Shelf s WHERE s.product.id = :productId")
@NamedQuery(name=Shelf.GET_ALL_SHELVES_IDS, query="SELECT s.id FROM Shelf s")

public class Shelf extends GenericEntity {
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_SHELVES_QUERY_NAME = "Shelf.getAllShelves";
	public static final String GET_SHELVES_BY_PRODUCT_ID_QUERY_NAME = "Shelf.GetShelvesByProductId";
	public static final String GET_ALL_SHELVES_IDS = "Shelf.getAllShelvesIds";
	
	@ManyToOne
	private Product product;
	private int capacity = 0;
	private int price = 0;
	
	public Shelf() {
		
	}
	
	public Shelf(Product product, int capacity, int price) {
		super();
		this.product = product;
		this.capacity = capacity;
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Shelf [product=" + product + ", capacity=" + capacity + ", price=" + price + "]";
	}

}