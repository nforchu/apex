package com.apex.services;

import com.apex.jpa.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
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
    public Product addProduct(Product product) {
        return null;
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
}
