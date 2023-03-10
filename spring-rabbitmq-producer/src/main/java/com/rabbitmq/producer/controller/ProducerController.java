package com.rabbitmq.producer.controller;

import com.rabbitmq.producer.model.Message;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;
    public String send(Message message){
        rabbitTemplate.convertAndSend(directExchange.getName(),"routing.A",message);
        return "Message send successfully";
    }
}
