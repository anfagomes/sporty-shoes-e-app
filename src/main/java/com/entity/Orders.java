package com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private LocalDateTime orderdatatime;
	private int quantity;
	private Integer productid;				// FK 	Integer can hold null value
	
	public Orders() {
		super();
	}


	public Orders(int orderid, LocalDateTime orderdatatime, int quantity, Integer productid) {
		super();
		this.orderid = orderid;
		this.orderdatatime = orderdatatime;
		this.quantity = quantity;
		this.productid = productid;
	}
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public LocalDateTime getOrderdatatime() {
		return orderdatatime;
	}
	public void setOrderdatatime(LocalDateTime orderdatatime) {
		this.orderdatatime = orderdatatime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
	
	
	
	

}
