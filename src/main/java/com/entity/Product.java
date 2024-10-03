package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;


@Entity
@Table(name="product")
public class Product {
	@Id
	//@Min(value = 1,message = "Value must be positive number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;
	
	@NotBlank(message = "Name cannot be empty.")
	private String name;
	
	@NotBlank(message = "Brand cannot be empty.")
	private String brand;
	private String size;
	private String type;
	
	@PositiveOrZero
	private int quantity;
	
	@Min(value = 1,message = "Price value must be > 1")
	private float price;
	
	/*
	 * @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
	 * CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	 * 
	 * @JoinTable(name= "productorder", joinColumns=@JoinColumn(name="productid"),
	 * inverseJoinColumns=@JoinColumn(name="orderid")) private List<Orders> orders;
	 */

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	/*
	 * public List<Orders> getOrders() { return orders; }
	 * 
	 * public void setOrders(List<Orders> orders) { this.orders = orders; }
	 */

	public Product() {
		super();
	}

	public Product(int productid, String name, String brand, String size, String type, int quantity, float price) {
		super();
		this.productid = productid;
		this.name = name;
		this.brand = brand;
		this.size = size;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		/* this.orders = orders; */
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", brand=" + brand + ", size=" + size + ", type="
				+ type + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
	
}
