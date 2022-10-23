package com.apex.services;

import com.apex.jpa.Category;
import com.apex.repository.CategoryRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepo;	
	
    public CategoryServiceImpl(CategoryRepository categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	@Override
    public Collection<Category> getCategories() {

        List<Category> list = new ArrayList<>();
        list.add(new Category().setId(1).setTitle("Men").setDescription("description for men's category"));
        list.add(new Category().setId(2).setTitle("Women").setDescription("description for women's category"));
        return list;
    }

    @Override
    public Category get(long id) {
        return new Category()
        		.setId(1)
        		.setTitle("Men")
        		.setDescription("description for men's category")
        		.setStatus("Active");
    }

	@Override
	public Category add(Category category) {
		return categoryRepo.save(category);
	}
}
