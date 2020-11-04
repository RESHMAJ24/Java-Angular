package com.ust.lastSBA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.lastSBA.entities.Product;
import com.ust.lastSBA.service.ProductService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/")
	public ResponseEntity<Void> addEmployee(@RequestBody Product product){
		
		productService.addProduct(product);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/")
	public List<Product> fetchAllProducts(){
		return productService.fetchAllProducts();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
		
		ResponseEntity<String> re = null;
		try{
			productService.deleteProduct(id);
			re = ResponseEntity.ok().body("Product has been deleted successfully.");
		}
		catch(EmptyResultDataAccessException e){

		}	
		return re;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> fetchProduct(@PathVariable("id")int id){
		ResponseEntity<Product> re = null; 
		Product product= productService.findProductById(id); 
		if(product==null){
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(product, HttpStatus.OK);
		}
		return re;
	}
}
