package com.apex.services;

import java.util.Collection;

import com.apex.jpa.Category;

public interface CategoryService {
	
	Collection<Category> getCategories();
	Category get(long id);
	Category add(Category category);
	Category update(Category category);
	void delete(long id);

}
