package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;
import com.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductContoller {
	
	
	@Autowired
	ProductService productService;
	
	
	// Add mapping for list - get all products
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String listProducts(Model model) {
		//get products from db
		List<Product> getProducts = productService.findAll();
		System.out.println("Product: "+ getProducts);
		//add to the spring model
		model.addAttribute("products",getProducts);
		return "listproducts";
		
	}
	
	// Add mapping for list - get all products
	@RequestMapping(value = "addProductForm",method = RequestMethod.GET)
	public String addProductForm(Model model) {
		Product product = new Product();
		
		//add to the spring model
		model.addAttribute("product",product);
		return "addproduct";
		
	}
	

}
