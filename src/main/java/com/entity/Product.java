package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="product")
public class Product {
	@Id
	private int id;
	
	@NotBlank(message = "Name cannot be empty.")
	private String name;
	
	@NotBlank(message = "Brand cannot be empty.")
	private String brand;
	private String size;
	private String type;
	
	@NotBlank(message = "Price cannot be empty.")
	private float price;
	private List<Order> order;
	

}
