package com.example.ordersservice.service;

import com.example.ordersservice.dto.Order;
import com.example.ordersservice.dto.Product;
import com.example.ordersservice.entity.Token;
import com.example.ordersservice.exception.InvalidCredentialsException;
import com.example.ordersservice.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final TokenRepository tokenRepository;



    public Order getOrder(final String token){
        Optional<Token> tokenOptional = tokenRepository.findByToken(token);

        if(tokenOptional.isPresent()){

            Product product1= new Product(1L, "Product1");
            Product product2= new Product(2L, "Product2");
            return new Order(1L, List.of(product1,product2));
        }
        throw new InvalidCredentialsException("Token is not a valid one");
    }

}
