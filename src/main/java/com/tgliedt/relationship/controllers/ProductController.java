package com.tgliedt.relationship.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tgliedt.relationship.models.Category;
import com.tgliedt.relationship.models.Product;
import com.tgliedt.relationship.services.CategoryService;
import com.tgliedt.relationship.services.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController (ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/productcategory/newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/productcategory/newProduct.jsp";
		}else {
			productService.create(product);
			return "redirect:/products/" + product.getId();
		}
	}
	
	@RequestMapping("/products/{id}")
	public String productPage(@PathVariable("id") Long id, Model model ) {
Product thisProduct = productService.findById(id);
		
		List<Category> thisProdsCats = thisProduct.getCategories();
		List<Category> categoriesForDropDown = categoryService.findAll();
		
		// remove the categories that have already been linked to this product from the categoriesForDropDown
		for (Category c : thisProdsCats) {
			if (categoriesForDropDown.contains(c)) {
				System.out.println("c.name: " + c.getName());
				categoriesForDropDown.remove(c);
			}
		}
		model.addAttribute("thisProduct", thisProduct);
		model.addAttribute("categoriesForDropDown", categoriesForDropDown);
		model.addAttribute("thisProdsCats", thisProdsCats);
		return "/productcategory/product.jsp";
	}
	
	
	@PostMapping("/product/{id}/addToCategory")
	public String addCategory(@RequestParam("category") Category category, @PathVariable("id") Long productId) {
		Product product = productService.findById(productId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		productService.update(product);
		return "redirect:/products/" + product.getId();
	}
	
}
