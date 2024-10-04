package com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.OrderItem;
import com.entity.Orders;
import com.entity.Product;
import com.entity.UserAccount;
import com.repository.OrdersRepository;
import com.repository.ProductRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserAccountService userAccountService;
	

    
	public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }
	
	public void addProductToOrder(Orders order, Product product, int quantity) {
		OrderItem productItem = new OrderItem(quantity,product);
		order.addOrderItem(productItem);
	}
	
	public void orderCheckout(Orders order, UserAccount userAccount) {
		System.out.println("Checkout Order: " +userAccount.getEmailid());
		order.setUserAccount(userAccountService.getUserByEmailId(userAccount.getEmailid()));
		order.setOrderdatatime(LocalDateTime.now());
		System.out.println("After:   "+order);
		ordersRepository.save(order);
	}

	public void removeFromCart(int orderItemid, Orders orderToSubmit) {
		orderToSubmit.removeOrderItem(orderItemid);
		
	}

	public List<Orders> findAllOrdersByEmaildId(String emailid) {
		return ordersRepository.findAllOrdersByEmailId(emailid);
	}

}
