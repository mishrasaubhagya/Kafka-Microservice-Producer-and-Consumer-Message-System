package com.example.producer_service.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class  ResponseListener {
    
    @KafkaListener(topics = "${response-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeResponse(String message) {
        System.out.println("Response received from Consumer -> " + message);
    }
}
