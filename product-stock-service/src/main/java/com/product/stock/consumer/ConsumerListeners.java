package com.product.stock.consumer;

import com.product.stock.dto.MessageRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class ConsumerListeners {
    @KafkaListener(topics = "test",groupId = "groupIdTest")
    public MessageRequest listener(MessageRequest data){
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setMessage(data.getMessage());
        System.out.println("Consumer listener: "+data);
        return messageRequest;
    }
}
