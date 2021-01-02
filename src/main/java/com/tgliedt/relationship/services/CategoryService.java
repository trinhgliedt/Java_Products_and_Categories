package com.tgliedt.relationship.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tgliedt.relationship.models.Category;
import com.tgliedt.relationship.models.Product;
import com.tgliedt.relationship.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public void create(Category c) {
		categoryRepository.save(c);
		return;
	}
	
	public Category findById(Long id) {
		Optional<Category> c = categoryRepository.findById(id);
		if(c.isPresent()) {
			return c.get();
		}else {
			return null;
		}
	}
	
	public void update(Category c) {
		categoryRepository.save(c);
	}
	
}
	
	
