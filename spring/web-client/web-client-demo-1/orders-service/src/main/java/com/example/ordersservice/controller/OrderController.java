package com.example.ordersservice.controller;

import com.example.ordersservice.dto.Order;
import com.example.ordersservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders/api/v1")
public class OrderController {

    private final OrderService orderService;


    @GetMapping
    public ResponseEntity<Order> getOrder(@RequestParam String token) {
        return ResponseEntity.ok(orderService.getOrder(token));
    }

}
