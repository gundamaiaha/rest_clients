package com.example.products.consumer.controller;

import com.example.products.consumer.dto.GetProductsResponse;
import com.example.products.consumer.dto.SearchProductsRequest;
import com.example.products.consumer.service.ProductsConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/productsConsumer")
public class ProductsConsumerController {

    private final ProductsConsumerService productsConsumerService;

    @GetMapping("/getProducts")
    public ResponseEntity<GetProductsResponse> getProducts() {
        return ResponseEntity.ok(productsConsumerService.getProducts());
    }

    @PostMapping("/searchProducts")
    public ResponseEntity<GetProductsResponse> searchProducts(@RequestBody(required = false) SearchProductsRequest searchProductsRequest) {
        return ResponseEntity.ok(productsConsumerService.searchProducts(searchProductsRequest));
    }
}
