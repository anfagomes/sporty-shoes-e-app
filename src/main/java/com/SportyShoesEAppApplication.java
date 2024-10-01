package com;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.LoginBack;
import com.entity.UserAccount;
import com.repository.LoginRepositoryBack;
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
		
		//LoginBack login = new LoginBack("admin@gmail.com","admin123");
		UserAccount userAccount = new UserAccount("admin@gmail.com", "admin123", "admin", "Active", "Admin");
		
		//Optional<LoginBack> result = Optional.ofNullable(loginRepository.findLoginByEmailId(login.getEmailId()));
		
		Optional<UserAccount> result = Optional.ofNullable(userAccountRepository.findUserAccountByEmailId(userAccount.getEmailid()));

		if(!result.isPresent()) {
			//Login login = new Login("admin@gmail.com","admin123");
			//UserAccount userAccount = new UserAccount("admin", "Active", "Admin");
			//userAccount.setLogin(login);
			System.out.println("Creating Admin account");
			userAccountRepository.save(userAccount);
		}
	}

}
