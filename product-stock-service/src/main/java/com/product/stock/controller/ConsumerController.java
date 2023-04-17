package com.product.stock.controller;

import com.product.stock.consumer.ConsumerListeners;
import com.product.stock.dto.MessageRequest;
import com.product.stock.service.TestConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerListeners testConsumerService;

    @GetMapping
    public MessageRequest string(MessageRequest messageRequest) {
        MessageRequest listener = testConsumerService.listener(messageRequest);
        return listener;
    }
}
