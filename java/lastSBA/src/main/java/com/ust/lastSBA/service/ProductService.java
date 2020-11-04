package com.ust.lastSBA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.lastSBA.entities.Product;
import com.ust.lastSBA.repos.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;

	public void addProduct(Product product) {
		
		productRepo.save(product);
	}

	public List<Product> fetchAllProducts() {
		return productRepo.findAll();
	}

	public void deleteProduct(int id) {
	 productRepo.deleteById(id);
	}

	public Product findProductById(int id) {
		
		Optional<Product> p = productRepo.findById(id);
		if(p.isPresent())
		{
			return p.get();
		}
		return null;
		
	}

}
