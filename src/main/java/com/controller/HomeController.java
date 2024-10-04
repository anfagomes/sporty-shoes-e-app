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
import com.entity.UserAccount;
import com.service.UserAccountService;

import jakarta.servlet.http.HttpSession;

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
	
	@GetMapping("/adminDashboard")
	public String adminDashboard(Model mm) {
		System.out.println("Admin dashboard");
		return "adminDashboard";		// using view resolver it check page inside 
							// template folder 
	}
	
	@GetMapping("/userDashboard")
	public String userDashboard(Model mm, @ModelAttribute("userAccount") UserAccount userAccount) {
		mm.addAttribute("userAccount", userAccount);
		System.out.println("User dashboard");
		return "userDashboard";		// using view resolver it check page inside 
							// template folder 
	}
	
	@PostMapping("/signIn")
	public String signIn(@ModelAttribute("userAccount") UserAccount userAccount, Model mm){ 
		String result = userAccountService.signIn(userAccount);
		System.out.println("sign result:" +result);
		if(result.equals("user")) {
			return "redirect:/userDashboard";
		}else {
			if(result.equals("admin")) {
				return "redirect:/adminDashboard";
			}else {
				return "redirect:/?error";
			}
		}
	}
	
	@GetMapping("/logout")
	public String logout(){ 
		System.out.println("Logout");
		return "redirect:/";
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
	
	@GetMapping("/userManagement")
	public String userManagement(Model model) { 
		System.out.println("User Management");
		List<UserAccount> getUserAccounts = userAccountService.findAllUsers();
		model.addAttribute("userAccounts", getUserAccounts);
		return "userManagement";
	}
	
	
	@PostMapping("/userManagement/filterByEmailId")
	public String filterByEmailId(Model model, @RequestParam("emailid") String emailid) { 
		System.out.println("User Management");
		UserAccount getUserAccount = userAccountService.findUserByEmailId(emailid);
		model.addAttribute("userAccounts", getUserAccount);
		return "userManagement";
	}
	
	
	@GetMapping("/userManagement/delete")
	public String delete(@RequestParam("emailid") String emailid, Model model) { 
		userAccountService.deleteById(emailid);  
		return "redirect:/userManagement";
	}
	
	@GetMapping("/userManagement/changeUserStatus")
	public String changeUserStatus(@ModelAttribute("userAccount") UserAccount userAccount, Model model) {
		UserAccount user = userAccountService.getUserByEmailId(userAccount.getEmailid()); 
		if(user != null) { 
			userAccountService.changeUserStatus(user);  
			return "redirect:/userManagement";
		}
		else {  
			return "invalid";
		}
	}
	
	@GetMapping("/changePassword")
	public String changePassowrd(@ModelAttribute("userAccount") UserAccount userAccount, Model model) {
		System.out.println(userAccount.getEmailid());
		UserAccount user = userAccountService.getUserByEmailId(userAccount.getEmailid()); 
		
		userAccountService.changeUserPassword(user);  
		
		if(user.getUsertype().equals("User")) { 
			return "redirect:/userDashboard";
		}
		else {  
			return "redirect:/adminDashboard";
		}
	}

}
