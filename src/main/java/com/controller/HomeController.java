package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;
import com.entity.UserAccount;
import com.service.UserAccountService;

@Controller
public class HomeController {
	
	
	@Autowired
	UserAccountService userAccountService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String showLogin(Model mm) {
		mm.addAttribute("userAccount", new UserAccount());
		System.out.println("Login page");
		return "login";		// using view resolver it check page inside 
							// template folder 
	}
	
	@GetMapping("/adminDasboard")
	public String adminDashboard() {
		System.out.println("Admin dashboard");
		return "adminDasboard";		// using view resolver it check page inside 
							// template folder 
	}
	
	@GetMapping("/userDashboard")
	public String userDashboard() {
		System.out.println("User dashboard");
		return "userDashboard";		// using view resolver it check page inside 
							// template folder 
	}
	
	@PostMapping("/signIn")
	public String signIn(@ModelAttribute("userAccount") UserAccount userAccount, Model mm){ 
		String result = userAccountService.signIn(userAccount);
		System.out.println("sign result:" +result);
		if(result.equals("user")) {
			//session.setAttribute("loggedInUser", ll);
			return "redirect:/userDashboard";
		}else {
			if(result.equals("admin")) {
				//session.setAttribute("loggedInUser", ll);
				return "redirect:/adminDashboard";
			}else {
				return "redirect:/?error";
			}
		}
	}
	
	@RequestMapping(value = "/userRegister",method = RequestMethod.GET)
	public String userRegister(Model mm) {
		mm.addAttribute("userAccount", new UserAccount());
		System.out.println("User Register page");
		return "userRegister";		// using view resolver it check page inside 
							// template folder 
	}
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute("userAccount") UserAccount userAccount, Model mm){ 
		String result = userAccountService.signUp(userAccount);
		System.out.println("sign result:" +result);
		if(result.equals("Success")) {
			return "redirect:/";
		}else {
			if(result.equals("Failure")) {
				System.out.println(result);
				mm.addAttribute("invalid", "Invalid Credentials!");
				return "redirect:/userRegister";
			}else {
				return "redirect:/?error";
			}
		}
	}
	

}
