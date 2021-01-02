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
public class CategoryController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public CategoryController (ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/productcategory/newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/productcategory/newCategory.jsp";
		}else {
			categoryService.create(category);
			return "redirect:/categories/" + category.getId();
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategoryPage(@PathVariable("id") Long id, Model model) {
		Category thisCategory = categoryService.findById(id);
		Product product = productService.findById(id);
		List<Product> catsProductList = thisCategory.getProducts();
		List<Product> productsForDropDown = productService.findAll();
		
		// remove the products that have already been linked to this category from the productsForDropDown
		for (Product p : catsProductList) {
			if (productsForDropDown.contains(p)) {
				productsForDropDown.remove(p);
			}
		}		
		model.addAttribute("product", product);
		model.addAttribute("thisCategory", thisCategory);
		model.addAttribute("thisCatsProducts", catsProductList);
		model.addAttribute("productsForDropDown", productsForDropDown);
		return "/productcategory/category.jsp";
	}
	
	@PostMapping("/categories/{id}/addProduct")
	public String addProduct(@PathVariable("id") Long id, @RequestParam(value="product") Product thisProduct, Model model) {
		System.out.println("Inside addProduct post method");
		Category chosenCategory = categoryService.findById(id);
		thisProduct.getCategories().add(chosenCategory);
		productService.save(thisProduct);
		model.addAttribute("thisCategory", chosenCategory);
		return "redirect:/categories/"+id;
	}
}
