package com.example.orderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String createOrder(@RequestBody String order) {
        logger.info("Received order: {}", order);
        kafkaTemplate.send("order-topic", order);
        logger.info("Order event published to Kafka topic 'order-topic'");
        return "Order Created & Event Published";
    }

    @GetMapping("/health")
    public String health() {
        return "Order Service is running!";
    }
}
