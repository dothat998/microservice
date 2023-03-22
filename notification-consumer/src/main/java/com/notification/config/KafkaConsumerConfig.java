package com.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@Configuration
public class KafkaConsumerConfig {

    //convert Byte => object
    @Bean
    JsonMessageConverter converter(){
        return new JsonMessageConverter();
    }

}
