package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String home() {
		System.out.println("Open home page");
		return "home";		// using view resolver it check page inside 
							// template folder 
	}

}
