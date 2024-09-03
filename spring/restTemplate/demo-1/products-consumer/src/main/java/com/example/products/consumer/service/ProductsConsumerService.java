package com.example.products.consumer.service;

import com.example.products.consumer.dto.GetProductsResponse;
import com.example.products.consumer.dto.SearchProductsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductsConsumerService {

    private final RestTemplate productsRestTemplate;

    @Value("${products.api.Url}")
    private String productsUrl;


    public GetProductsResponse getProducts() {
        return productsRestTemplate.getForObject(productsUrl, GetProductsResponse.class);
    }

    public GetProductsResponse searchProducts(SearchProductsRequest searchProductsRequest) {
        return productsRestTemplate.postForObject(productsUrl, searchProductsRequest, GetProductsResponse.class);
    }

}
