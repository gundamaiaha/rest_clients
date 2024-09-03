package com.example.orderservice.util;

import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.Product;
import com.example.orderservice.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrdersDataLoader {

    private final OrderRepository orderRepository;


    @PostConstruct
    void loadOrders() {
        Product product = new Product();
        product.setProductName("test product1");

        Order order = new Order();
        order.setProducts(List.of(product));

        product.setOrder(order);

        orderRepository.save(order);
    }


}
