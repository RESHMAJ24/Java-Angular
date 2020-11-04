package com.ust.lastSBA.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.lastSBA.entities.Product;


public interface ProductRepo extends JpaRepository<Product, Integer>{

}
