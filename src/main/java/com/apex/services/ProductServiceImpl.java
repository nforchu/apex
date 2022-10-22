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
                        .setTitle("Sneakers A"));
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }
}
