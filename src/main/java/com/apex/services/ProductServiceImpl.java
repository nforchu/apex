package com.apex.services;

import com.apex.jpa.Category;
import com.apex.jpa.Product;
import com.apex.repository.CategoryRepository;
import com.apex.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepo;
	private CategoryRepository categoryRepo;
			
    

	public ProductServiceImpl(ProductRepository productRepo, CategoryRepository categoryRepo) {
		super();
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}

	@Override
    public Collection<Product> getProducts() {
        return productRepo.findAll();
        
    }

	@Override
	public Product get(long id) {		
		return productRepo.findById(id).get();
	}

	@Override
	public Product add(Product product, long[] categoryIds) {
		for(long id: categoryIds) {
			product.addCategory(categoryRepo.findById(id).get());
		}
		return productRepo.save(product);
	}

	@Override
	public Product update(Product product, long[] categoryIds) {
		
		Optional<Product> optional = productRepo.findById(product.getId());
		if(optional.isEmpty()) {
			throw new RuntimeException("NOT FOUND");
		}		
		Product prod = optional.get().setTitle(product.getTitle())
									 .setPrice(product.getPrice())
									 .setDescription(product.getDescription())
									 .setDiscountPercent(product.getDiscountPercent())
									 .setStockQuantity(product.getStockQuantity());
	
		
		for(Category cat: new HashSet<Category>(prod.getCategories())) {
			if (Arrays.asList(categoryIds).indexOf(cat.getId()) < 0) {
				prod.removeCategory(cat);
			}
		}
			
		for(long id: categoryIds) {			
			Category match = prod.getCategories().stream()
								.filter(p -> p.getId() == id)
								.findAny().orElse(null); 
			if(match == null) {
				Optional<Category> opt = categoryRepo.findById(id);
				if(opt.isEmpty()) {
					throw new RuntimeException("NOT FOUND");
				}
				prod.addCategory(opt.get());
			}
		}
		
		return productRepo.save(prod);
	}
}
