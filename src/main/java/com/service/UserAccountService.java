package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserAccount;
import com.repository.UserAccountRepository;

@Service
public class UserAccountService {
	
	static final String ACTIVE="Active";
	static final String USER="User";
	
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	public String signIn(UserAccount userAccount) {
		if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()) == null ||
				(!userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()).getStatus().contentEquals("Active"))) {
			return "failure";
		} else {
			if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()).getPassword().contentEquals(userAccount.getPassword().toString())) {
				if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()).getUsertype().contentEquals("Admin")) {
					return "admin";
				} else {
					return "user";
				}
			
			} else {
				return "failure";
			}
		}
	}
	
	public String signUp(UserAccount userAccount) {
		if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()) != null) {
			return "Failure";
		} else {
			UserAccount newUserAccount = new UserAccount();
			
			newUserAccount.setEmailid(userAccount.getEmailid());
			newUserAccount.setPassword(userAccount.getPassword());
			newUserAccount.setUsername(userAccount.getUsername());
			newUserAccount.setStatus(ACTIVE);
			newUserAccount.setUsertype(USER);
			userAccountRepository.save(newUserAccount);
			return "Success";
		}
	}
	
	

}
