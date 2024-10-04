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

import jakarta.servlet.http.HttpSession;

@Controller
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserAccountService userAccountService;
	
	private Orders orderToSubmit = new Orders();
	
	@GetMapping("/purchaseReport")
	public String findAllOrders(Model model) {
		//get products from db
		List<Orders> getOrders = ordersService.findAllOrders();
		System.out.println("Orders: "+ getOrders);
		//add to the spring model
		model.addAttribute("orders",getOrders);
		return "purchaseReport";
	}
	
	@GetMapping("/myorders")
	public String findAllOrdersByEmaildId(Model model, HttpSession session) {
		
		UserAccount loginUserAccount = (UserAccount) session.getAttribute("loginuser");
		System.out.println("Myorders Login:"+loginUserAccount.getEmailid());
		model.addAttribute("loginuser", loginUserAccount);
		
		
		List<Orders> getOrders = ordersService.findAllOrdersByEmaildId(loginUserAccount.getEmailid());
		System.out.println("getOrders: "+ getOrders);
		//add to the spring model
		model.addAttribute("orders",getOrders);
		return "orders";
	}

	
	@GetMapping("/purchaseReport/filterByDate")
	public String findOrdersByDate(Model model, @ModelAttribute("userAccount") UserAccount userAccount) {
		//get products from db
		List<Orders> getOrders = ordersService.findAllOrdersByEmaildId(userAccount.getEmailid());
		System.out.println("Orders: "+ getOrders);
		//add to the spring model
		model.addAttribute("orders",getOrders);
		return "purchaseReport";
	}
	
	@PostMapping("/purchaseReport/filterByEmailid")
	public String findOrdersByProductType(Model model, @ModelAttribute("emailid") String emailid) {
		//get products from db
		List<Orders> getOrders = ordersService.findAllOrdersByEmaildId(emailid);
		System.out.println("Orders: "+ getOrders);
		//add to the spring model
		model.addAttribute("orders",getOrders);
		return "purchaseReport";
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
	public String orderCheckout(HttpSession session, Model model) {
		
		UserAccount loginUserAccount = (UserAccount) session.getAttribute("loginuser");
		System.out.println("Myorders Login:"+loginUserAccount.getEmailid());
		model.addAttribute("loginuser", loginUserAccount);
		
		
		ordersService.orderCheckout(orderToSubmit, loginUserAccount);
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
	public String delete(@RequestParam("item") int orderItemid, Model model) { 
		ordersService.removeFromCart(orderItemid,orderToSubmit);
		return "redirect:/catalog";
	}
	
	
	
	
	
}
