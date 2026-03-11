package com.example.inventoryservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryListener {

    private static final Logger logger = LoggerFactory.getLogger(InventoryListener.class);

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void handleOrderEvent(String order) {
        logger.info("===== INVENTORY SERVICE =====");
        logger.info("Received order event: {}", order);
        logger.info("Stock updated for order.");
        logger.info("=============================");
    }
}
