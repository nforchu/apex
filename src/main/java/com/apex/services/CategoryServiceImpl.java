package com.apex.services;

import com.apex.jpa.Category;
import com.apex.repository.CategoryRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepo;	
	
    public CategoryServiceImpl(CategoryRepository categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	@Override
    public Collection<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category get(long id) {
        return categoryRepo.findById(id).get();
    }

	@Override
	public Category add(Category category) {
		category.setStatus("Active");
		return categoryRepo.save(category);
	}

	@Override
	public Category update(Category category) {
		Optional<Category> optional = categoryRepo.findById(category.getId());
		if(optional.isEmpty()) {
			throw new RuntimeException("NOT FOUND");
		}	
		Category cat = optional.get().setTitle(category.getTitle())
									 .setDescription(category.getDescription());
		return categoryRepo.save(cat);
	}

	@Override
	public void delete(long id) {
		categoryRepo.deleteById(id);		
	}
}
