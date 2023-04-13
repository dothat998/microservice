package com.product.stock.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class ConsumerListeners {
    @KafkaListener(topics = "test",groupId = "groupIdTest")
    void listener(String data){
        System.out.println("Consumer listener: "+ data);
    }
}
