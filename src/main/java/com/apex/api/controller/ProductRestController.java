package com.apex.api.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apex.jpa.Product;
import com.apex.services.ProductService;

@RestController
@RequestMapping(value = "api/products")
@CrossOrigin("*")
public class ProductRestController {
	
	private ProductService productService;
	
	

    public ProductRestController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping
    public ResponseEntity<?> all() {
		Collection<Product> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    
    @GetMapping(value = "{id}")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(HttpStatus.OK).body("all good product list");
    }
}
