package com.apex.services;

import com.apex.jpa.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> getProducts();
    Product get(long id);
    Product addProduct(Product product);
    
}
