package com.example.billingservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BillingListener {

    private static final Logger logger = LoggerFactory.getLogger(BillingListener.class);

    @KafkaListener(topics = "order-topic", groupId = "billing-group")
    public void handleOrderEvent(String order) {
        logger.info("===== BILLING SERVICE =====");
        logger.info("Received order event: {}", order);
        logger.info("Invoice generated for order.");
        logger.info("===========================");
    }
}
