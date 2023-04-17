package com.product.stock.controller;

import com.netflix.discovery.converters.Auto;
import com.product.stock.consumer.ConsumerListeners;
import com.product.stock.dto.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {

    @Autowired
    ConsumerListeners consumerListeners;

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public MessageRequest publish(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("test", messageRequest.getMessage());
        return messageRequest;
    }

}
