package com.example.products.service;

import com.example.products.dto.ProductDto;
import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import com.example.products.util.ProductsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productRepository;

    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductsMapper::mapToDto).toList();
    }

    public List<ProductDto> getProductsByName(String name) {
        List<Product> products = productRepository.findByName(name);
        return products.stream().map(ProductsMapper::mapToDto).toList();
    }

    public List<ProductDto> getProductsByPrice(double price) {
        List<Product> products = productRepository.findByPrice(price);
        return products.stream().map(ProductsMapper::mapToDto).toList();
    }

}
