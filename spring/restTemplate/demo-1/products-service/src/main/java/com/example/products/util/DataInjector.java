package com.example.products.util;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInjector {
    private final ProductRepository productRepository;

    @PostConstruct
    public void injectData() {
        for (int i = 1; i <= 10; i++) {
            productRepository.save(
                    new Product("Product " + i, i*100.0));
        }
    }
}
