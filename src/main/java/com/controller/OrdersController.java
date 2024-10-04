package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Orders;
import com.entity.Product;
import com.entity.UserAccount;
import com.service.OrdersService;
import com.service.ProductService;
import com.service.UserAccountService;

@Controller
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserAccountService userAccountService;
	
	private Orders orderToSubmit = new Orders();
	
	@GetMapping("/orders")
	public String findAllOrders(Model model) {
		//get products from db
		List<Orders> getOrders = ordersService.findAllOrders();
		System.out.println("Product: "+ getOrders);
		//add to the spring model
		model.addAttribute("products",getOrders);
		return "orders";
	}
	
	@GetMapping("/userOrders")
	public String findAllOrdersByEmaildId(Model model, @ModelAttribute("userAccount") UserAccount userAccount) {
		//get products from db
		List<Orders> getOrders = ordersService.findAllOrdersByEmaildId(userAccount.getEmailid());
		System.out.println("Product: "+ getOrders);
		//add to the spring model
		model.addAttribute("products",getOrders);
		return "orders";
	}
	
	@GetMapping("/catalog/addProductToOrder")
	public String addProductToOrder(@RequestParam("productId") int productId, Model model) {
		
		Product productToAdd = productService.findById(productId);	
		
		if(productToAdd != null) { 
			ordersService.addProductToOrder(orderToSubmit, productToAdd,1);
			System.out.println("Order to submit:" +orderToSubmit.getOrderItem());
			//model.addAttribute("orderToSubmit",orderToSubmit.getOrderItem());
			return "redirect:/catalog";
		} else {  
			return "Product not found";
		}
	}
	
	@PostMapping("/catalog/checkout")
	public String orderCheckout() {
		ordersService.orderCheckout(orderToSubmit);
		orderToSubmit = new Orders();
		return "redirect:/catalog";
		
	}
    
	@GetMapping("/catalog")
	public String showCatalog(Model model) {
		model.addAttribute("userAccount", new UserAccount());
		//get products from db
		List<Product> getProducts = productService.findAll();
		System.out.println("Product: "+ getProducts);
		//add to the spring model
		model.addAttribute("products",getProducts);
		model.addAttribute("orderToSubmit", orderToSubmit);
		return "catalog";
	}
	
	@GetMapping("/catalog/removeFromCart")
	public String delete(@RequestParam("orderItemid") int orderItemid, Model model) { 
		ordersService.removeFromCart(orderItemid,orderToSubmit);
		return "redirect:/catalog";
	}
	
	
	
	
	
}
