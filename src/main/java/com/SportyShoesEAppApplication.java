package com;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.UserAccount;
import com.repository.UserAccountRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repository")
public class SportyShoesEAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesEAppApplication.class, args);
	}
	
	
	//  @Autowired LoginRepositoryBack loginRepository;
	 
	@Autowired
	UserAccountRepository userAccountRepository;
	
	@PostConstruct
	public void init() {

		UserAccount userAccount1 = new UserAccount("admin@gmail.com", "admin123", "admin", "Active", "Admin");
		UserAccount userAccount2 = new UserAccount("user@gmail.com", "123", "user", "Active", "User");
		Optional<UserAccount> result1 = Optional.ofNullable(userAccountRepository.findUserAccountByEmailId(userAccount1.getEmailid()));
		Optional<UserAccount> result2 = Optional.ofNullable(userAccountRepository.findUserAccountByEmailId(userAccount2.getEmailid()));

		if(!result1.isPresent()) {
			System.out.println("Creating Admin account");
			userAccountRepository.save(userAccount1);
		}
		
		if(!result2.isPresent()) {
			System.out.println("Creating User account");
			userAccountRepository.save(userAccount2);
		}
	}

}
