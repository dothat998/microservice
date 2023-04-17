package com.product.stock.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic testTopic(){
        return TopicBuilder.name("test").build();
    }

    @Bean
    NewTopic notification(){
        //topic name, partition, replication number
        return new NewTopic("notification",2,(short) 1);
    }
    @Bean
    NewTopic statistic(){
        return new NewTopic("statistic",2,(short) 1);
    }
}
