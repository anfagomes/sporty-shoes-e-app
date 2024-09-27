package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


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
	
	@NotBlank(message = "Quantity cannot be empty.")
	private int quantity;
	
	@NotBlank(message = "Price cannot be empty.")
	private float price;
	
	@OneToMany
	@JoinColumn(name = "productid")					// make productId as FK in orders table. 
	private List<Orders> orders;
	

}
