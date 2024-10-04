package com.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	@Query("select o from Orders o where o.userAccount.emailid = :emailid") 
	public List<Orders> findAllOrdersByEmailId(@Param("emailid") String emailid);

    @Query("SELECT o FROM Orders o WHERE o.orderdatatime BETWEEN :startDate AND :endDate")
    public List<Orders> findOrdersWithinDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
