package com.apex.services;

import com.apex.jpa.Category;
import com.apex.jpa.Product;
import com.apex.repository.CategoryRepository;
import com.apex.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        List<Product> products = new ArrayList<>();
        products.add(new Product()
                        .setId(1L)
                        .setDescription("Sample product description")
                        .setPrice(120.56F)
                        .setStockQuantity(50)
                        .setDiscountPercent(0)
                        .setTitle("Sneakers A"));
        products.add(new Product()
                .setId(1L)
                .setDescription("Sample product description")
                .setPrice(12.99F)
                .setStockQuantity(30)
                .setDiscountPercent(15)
                .setTitle("Hats A"));
        products.add(new Product()
                .setId(1L)
                .setDescription("Sample product description")
                .setPrice(99.89F)
                .setStockQuantity(30)
                .setDiscountPercent(10)
                .setTitle("Skirts "));
        return products;
    }

	@Override
	public Product get(long id) {		
		return new Product()
                .setId(1L)
                .setDescription("Sample product description")
                .setPrice(120.56F)
                .setStockQuantity(30)
                .setDiscountPercent(0)
                .setTitle("Sneakers A");
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
		return null;
	}
}
