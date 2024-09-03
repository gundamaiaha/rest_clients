package com.example.ordersservice.controller;

import com.example.ordersservice.dto.Order;
import com.example.ordersservice.service.OrdersConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-consumer/api/v1")
public class OrderConsumerController {

    private final OrdersConsumerService ordersConsumerService;


    @GetMapping
    public ResponseEntity<Order> getOrder() {
        return ResponseEntity.ok(ordersConsumerService.getOrder());
    }

}
