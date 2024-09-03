package com.example.products.controller;

import com.example.products.dto.GetProductsResponse;
import com.example.products.dto.SearchProductsRequest;
import com.example.products.repository.ProductRepository;
import com.example.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductsController {

    private final ProductsService productsService;


    @GetMapping
    public ResponseEntity<GetProductsResponse> getAll(){
        return ResponseEntity.ok(new GetProductsResponse(productsService.getProducts()));
    }

    @PostMapping
    public ResponseEntity<GetProductsResponse> searchProducts(@RequestBody(required = false) SearchProductsRequest searchProductsRequest){
        GetProductsResponse getProductsResponse = null;
         if(isEmpty(searchProductsRequest) || (
                isEmpty(searchProductsRequest.getName()) && isEmpty(searchProductsRequest.getPrice()))){
              getProductsResponse= new GetProductsResponse(productsService.getProducts());
          }else if(!ObjectUtils.isEmpty(searchProductsRequest.getName())){
              getProductsResponse= new GetProductsResponse(productsService.getProductsByName(searchProductsRequest.getName()));
          } else if (!ObjectUtils.isEmpty(searchProductsRequest.getPrice())){
              getProductsResponse= new GetProductsResponse(productsService.getProductsByPrice(searchProductsRequest.getPrice()));
         }
        return ResponseEntity.ok(getProductsResponse);
    }




}
