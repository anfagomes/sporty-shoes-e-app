package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String listProducts(Model model) {
		//get products from db
		List<Product> getProducts = productService.findAll();
		System.out.println("Product: "+ getProducts);
		//add to the spring model
		model.addAttribute("products",getProducts);
		return "products";
		
	}
	
	// Add new product form
	@RequestMapping(value = "addproduct",method = RequestMethod.GET)
	public String addProductForm(Model model) {

		model.addAttribute("product",new Product());
		return "addproduct";
		
	}
	
	
	// Save product in database
	@RequestMapping(value = "save",method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		// redirect to avoid duplicates
		return "redirect:/products";
		
	}
	
	
	
	

}
