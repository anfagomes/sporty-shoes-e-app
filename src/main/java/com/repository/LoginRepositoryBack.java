package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.LoginBack;

//@Repository
public interface LoginRepositoryBack extends JpaRepository<LoginBack, String>{
	
	
	@Query("select l from Login l where l.emailid = :emailid")
	public LoginBack findLoginByEmailId(@Param("emailid") String emailid);

}
