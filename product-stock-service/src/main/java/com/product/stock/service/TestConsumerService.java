package com.product.stock.service;

import com.netflix.discovery.converters.Auto;
import com.product.stock.consumer.ConsumerListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestConsumerService {
    @Autowired
    ConsumerListeners consumerListeners;
    public String string (){
        String s1 = consumerListeners.toString();
        return s1;
    }
}
