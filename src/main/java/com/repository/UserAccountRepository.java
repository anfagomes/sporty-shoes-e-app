package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String>{

	@Query("select u from UserAccount u where u.emailid = :emailid")
	public UserAccount findUserAccountByEmailId(@Param("emailid") String emailid);
	
	@Query("select u from UserAccount u where u.usertype = 'User'")
	public List<UserAccount> findAllUsersWithUsertypeUser();

}
