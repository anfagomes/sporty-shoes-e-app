package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String openPage() {
		System.out.println("index page open");
		return "index";		// using view resolver it check page inside 
							// template folder 
	}

}
