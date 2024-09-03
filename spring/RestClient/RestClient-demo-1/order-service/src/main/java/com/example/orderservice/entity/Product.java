package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String productName;


    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;


}
