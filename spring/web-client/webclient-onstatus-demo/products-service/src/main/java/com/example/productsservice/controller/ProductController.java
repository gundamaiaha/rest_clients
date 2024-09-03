package com.example.productsservice.controller;

import com.example.productsservice.entity.Product;
import com.example.productsservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }


}
