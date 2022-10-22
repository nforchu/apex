package com.apex.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductRestController {

    @GetMapping
    public ResponseEntity<?> all() {
        return ResponseEntity.status(HttpStatus.OK).body("all good product list");
    }
}
