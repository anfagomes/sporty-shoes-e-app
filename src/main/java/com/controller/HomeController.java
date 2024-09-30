package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Login;

@Controller
public class HomeController {
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String home() {
		System.out.println("Login page");
		return "login";		// using view resolver it check page inside 
							// template folder 
	}
	
	@GetMapping("/admin")
	public String adminDashboard() {
		System.out.println("Admin dashboard");
		return "admin";		// using view resolver it check page inside 
							// template folder 
	}
	
	@GetMapping("/user")
	public String userDashboard() {
		System.out.println("User dashboard");
		return "user";		// using view resolver it check page inside 
							// template folder 
	}
	
//	@RequestMapping(value = "signIn",method = RequestMethod.POST)
//	public String signIn(Login login, Model mm) {  
//		mm.addAttribute("login", login);		
//		String result = loginService.signIn(ll);
//		if(result.equals("user")) {
//			session.setAttribute("loggedInUser", ll);
//			return "redirect:/user";
//		}else {
//			if(result.equals("admin")) {
//				session.setAttribute("loggedInUser", ll);
//				return "redirect:/admin";
//			}else {
//				return "redirect:/login?error";
//			}
//		}
//	}
	

}
