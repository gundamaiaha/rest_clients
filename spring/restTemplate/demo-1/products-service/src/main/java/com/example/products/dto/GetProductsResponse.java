package com.example.products.dto;

import com.example.products.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductsResponse {
    private List<ProductDto> products;
}
