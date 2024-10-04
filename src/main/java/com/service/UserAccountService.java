package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.UserAccount;
import com.repository.UserAccountRepository;

@Service
public class UserAccountService {
	
	static final String ACTIVE="Active";
	static final String BLOCKED="Blocked";
	static final String USER="User";
	static final String ADMIN="Admin";
	
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	public String signIn(UserAccount userAccount) {
		if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()) == null ||
				(!userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()).getStatus().equals(ACTIVE))) {
			return "failure";
		} else {
			if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()).getPassword().contentEquals(userAccount.getPassword().toString())) {
				if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()).getUsertype().equals(ADMIN)) {
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
	
	public UserAccount getUserByEmailId(String emailId) {
        Optional<UserAccount> result = userAccountRepository.findById(emailId);

        UserAccount userAccount = null;

        if (result.isPresent()) {
        	userAccount = result.get();
        }
        else {
            // we didn't find the product
            throw new RuntimeException("Did not find email - " + emailId);
        }

        return userAccount;
		
	}
	
	public void changeUserStatus(UserAccount userAccount) {	
		userAccountRepository.save(userAccount);
	}
	
    public void deleteById(String emailid) {
    	userAccountRepository.deleteById(emailid);
    }
    
	public List<UserAccount> findAllUsers() {
        return userAccountRepository.findAllUsersWithUsertypeUser();
    }
	
	public void changeUserPassword(UserAccount userAccount) {	
		if(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid().toString()).getStatus().equals(ACTIVE)) {
			userAccount.setStatus(BLOCKED);
			System.out.println("UserAccountService Blockec " +userAccount);
			userAccountRepository.save(userAccount);
		} else {
			userAccount.setStatus(ACTIVE);
			System.out.println("UserAccountService Active " +userAccount);
			userAccountRepository.save(userAccount);
		}
	}

	public UserAccount findUserByEmailId(String emailid) {
        return userAccountRepository.findUserAccountByEmailId(emailid);
	}


	
	

}
