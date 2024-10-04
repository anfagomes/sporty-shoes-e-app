package com.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private LocalDateTime orderdatatime;
	private int quantity;
	private float totalAmount;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "emailid", nullable = false)
	private UserAccount userAccount;
	
	
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
   
	public Orders() {
		super();
	}



	public Orders(int orderid, LocalDateTime orderdatatime, int quantity, float totalAmount, UserAccount userAccount,
			List<OrderItem> orderItems) {
		super();
		this.orderid = orderid;
		this.orderdatatime = orderdatatime;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.userAccount = userAccount;
		this.orderItems = orderItems;
	}



	public UserAccount getUserAccount() {
		return userAccount;
	}



	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}



	public List<OrderItem> getOrderItem() {
		return orderItems;
	}



	public void setOrderItem(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
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

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}



	public void addOrderItem(OrderItem productItem) {
		orderItems.add(productItem);
		totalAmount+= productItem.getProduct().getPrice();
		quantity+=1;
	}



	public void removeOrderItem(int orderItemid) {
		totalAmount-=orderItems.get(orderItemid).getProduct().getPrice();
		quantity-=1;
		orderItems.remove(orderItemid);
		
	}
}
