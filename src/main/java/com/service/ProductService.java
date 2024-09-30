package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

    
	public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int productId) {
        Optional<Product> result = productRepository.findById(productId);

        Product product = null;

        if (result.isPresent()) {
        	product = result.get();
        }
        else {
            // we didn't find the product
            throw new RuntimeException("Did not find product id - " + productId);
        }

        return product;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(int productId) {
    	productRepository.deleteById(productId);
    }
    
    public List<Product> findAllByBrand(String brand) {
    	return productRepository.findAllByBrand(brand);
    	
    	
    }
	

}
