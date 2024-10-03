package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.service.ProductService;

@Controller
public class ProductContoller {
	
	
	@Autowired
	ProductService productService;
	
	
	// Add mapping for list - get all products
	//@RequestMapping(value = "",method = RequestMethod.GET)
	@GetMapping("/products")
	public String listProducts(Model model) {
		//get products from db
		List<Product> getProducts = productService.findAll();
		System.out.println("Product: "+ getProducts);
		//add to the spring model
		model.addAttribute("products",getProducts);
		return "products";
		
	}
	
	// Add new product form
	//@RequestMapping(value = "productFormAdd",method = RequestMethod.GET)
	@GetMapping("/products/productFormAdd")
	public String addProductForm(Model model) {

		model.addAttribute("product",new Product());
		return "productform";
		
	}
	
	// Form to update
	
	  //@RequestMapping(value = "productFormUpdate",method = RequestMethod.GET)
	@GetMapping("/products/productFormUpdate")
	public String productFormUpdate(@RequestParam("productId") int productId, Model model) {	  
		Product product = productService.findById(productId);
		model.addAttribute("product",product); 
		  
		return "productform";
	 }
	  
	@GetMapping("/products/delete")
	public String delete(@RequestParam("productId") int productId, Model model) { 
		productService.deleteById(productId);  
		return "redirect:/products";
	}
	 
	
	
	// Save product in database

	@PostMapping("/products/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		// redirect to avoid duplicates
		return "redirect:/products";
		
	}
	
	
	
	@GetMapping("/catalog")
	public String showCatalog(Model model) {
		//get products from db
		List<Product> getProducts = productService.findAll();
		System.out.println("Product: "+ getProducts);
		//add to the spring model
		model.addAttribute("products",getProducts);
		return "catalog";
		
	}
	
	
	
	

}
