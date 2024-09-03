package com.example.ordersservice.service;

import com.example.ordersservice.dto.GetTokenRequest;
import com.example.ordersservice.dto.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrdersConsumerService {

    private final WebClient webClient;

    private final RestClient restClient;


    public Order getOrder() {
        //getToken
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setClientId("123");
        getTokenRequest.setClientSecret("test-secret");

        MultiValueMap<String,Object> requestMap= new LinkedMultiValueMap<>();
        requestMap.put("clientId", List.of("123"));
        requestMap.put("clientSecret", List.of("test-secret"));



        String token = restClient
                .post()
                .uri("/token/api/v1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(requestMap)
                .retrieve()
                .body(String.class);
        System.out.println("token = " + token);
        Order order = restClient.get()
                .uri("/orders/api/v1?token={token}", Map.of("token", token))
                .retrieve()
                .body(Order.class);
        System.out.println("order = " + order);


        return order;


    }


}
