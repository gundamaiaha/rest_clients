package com.example.products.util;

import com.example.products.dto.ProductDto;
import com.example.products.model.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductsMapper {

    public ProductDto mapToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }

}
