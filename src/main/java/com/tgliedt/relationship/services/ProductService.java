package com.tgliedt.relationship.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tgliedt.relationship.models.Product;
import com.tgliedt.relationship.repositories.ProductRepository;

@Service
public class ProductService{

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public void create(Product p) {
		this.productRepository.save(p);
	}
	
	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}
	
	public void update(Product p) {
		this.productRepository.save(p);
		return;
	}
	public void save(Product product) {
		productRepository.save(product);
	}
	
}