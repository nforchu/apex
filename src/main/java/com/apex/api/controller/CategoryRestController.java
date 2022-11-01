package com.apex.api.controller;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apex.jpa.Category;
import com.apex.services.CategoryService;


@CrossOrigin("*")
@RestController
@RequestMapping("categories")
public class CategoryRestController {
	
	private CategoryService categoryService;

	public CategoryRestController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping
	public Collection<Category> get() {
		
		return categoryService.getCategories();
	}
}


