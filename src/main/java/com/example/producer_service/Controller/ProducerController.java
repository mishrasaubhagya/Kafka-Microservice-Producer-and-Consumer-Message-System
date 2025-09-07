package com.example.producer_service.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.one}")
    private String topicOne;

    @Value("${topic.two}")
    private String topicTwo;

    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/topic1/{message}")
    public String sendToTopic1(@PathVariable String message)
    {
        kafkaTemplate.send(topicOne, message);
        return "Message sent to topic1: " + message;
    }

    @PostMapping("/topic2/{message}")
    public String sendToTopic2(@PathVariable String message)
    {
        kafkaTemplate.send(topicTwo, message);
        return "Message sent to topic2: " + message;
    }
    
}
