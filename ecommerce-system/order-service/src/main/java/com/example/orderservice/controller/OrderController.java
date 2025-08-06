package com.example.orderservice.controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderMapper orderMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setStatus("PENDING");
        orderMapper.insert(order);
        kafkaTemplate.send("order-topic", "Order created: " + order.getId());
        return order;
    }
}