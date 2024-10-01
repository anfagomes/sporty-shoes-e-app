package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserAccount;
import com.repository.UserAccountRepository;

@Service
public class UserAccountService {
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	public String signIn(UserAccount userAccount) {
		if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()) == null ||
				(userAccountRepository.findUserAccountByEmailId(userAccount.getStatus().toString()).getStatus().contentEquals("Active"))) {
			return "login fail";
		} else {
			if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()).getPassword().contentEquals(userAccount.getPassword().toString())) {
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
