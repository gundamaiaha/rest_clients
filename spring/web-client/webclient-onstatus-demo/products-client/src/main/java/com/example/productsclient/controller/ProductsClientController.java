package com.example.productsclient.controller;

import com.example.productsclient.model.Product;
import com.example.productsclient.service.ProductClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products/client")
public class ProductsClientController {

    private final ProductClientService productClientService;


    @GetMapping
    public ResponseEntity<Mono<List<Product>>> getAllProducts() {
        return ResponseEntity.ok(productClientService.getAllProducts());
    }


    @PostMapping
    public ResponseEntity<Mono<Product>> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productClientService.addProduct(product));
    }
}
