package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Login;

@Controller
public class HomeController {
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String home() {
		System.out.println("Open home page");
		return "home";		// using view resolver it check page inside 
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
