package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.LoginBack;
import com.entity.UserAccount;
import com.repository.LoginRepositoryBack;
import com.repository.UserAccountRepository;

//@Service
public class LoginServiceBack {
	
	@Autowired
	LoginRepositoryBack loginRepository;
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	public String signIn(LoginBack login, UserAccount userAccount) {
		if(loginRepository.findLoginByEmailId(login.getEmailId().toString()) == null ||
				(userAccountRepository.findUserAccountByEmailId(userAccount.getStatus().toString()).getStatus().contentEquals("Active"))) {
			return "login fail";
		} else {
			if(loginRepository.findLoginByEmailId(login.getEmailId().toString()).getPassword().contentEquals(login.getPassword().toString())) {
				if(userAccountRepository.findUserAccountByEmailId(userAccount.getUsertype().toString()).getUsertype().contentEquals("Admin")) {
					return "admin";
				} else {
					return "user";
				}
			
			} else {
				return "login fail";
			}
		}
	}

}
