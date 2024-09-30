package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.entity.Orders;
import com.service.OrdersService;

@Controller
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@GetMapping("/orders")
	public String listOrders(Model model) {
		//get products from db
		List<Orders> getOrders = ordersService.findAll();
		System.out.println("Product: "+ getOrders);
		//add to the spring model
		model.addAttribute("products",getOrders);
		return "orders";
	}
	
	
}
