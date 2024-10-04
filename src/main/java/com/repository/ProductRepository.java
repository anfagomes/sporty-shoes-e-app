package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	// find by brand
	@Query("select p from Product p where p.type = :type")
	public List<Product> findAllProductsByType(@Param("type") String brand);
	
	// find by Size
	@Query("select p from Product p where p.size = :my_size")
	public List<Product> findAllBySize(@Param("my_size") String size);
	
	
	// add a method to sort by 
}
