package com.example.productsservice.service;

//write Product service class that will use ProductRepository to get all products and insert a new product


import com.example.productsservice.entity.Product;
import com.example.productsservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }


}
