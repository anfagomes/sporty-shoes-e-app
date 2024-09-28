package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Product;
import com.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductContoller {
	
	
	@Autowired
	ProductService productService;
	
	
	// Add mapping for list - get all products
	@GetMapping("/list")
	public String listProducts(Model model) {
		//get products from db
		List<Product> products = productService.findAll();
		//add to the spring model
		model.addAttribute("products",products);
		return "listproducts";
		
	}
	

}
