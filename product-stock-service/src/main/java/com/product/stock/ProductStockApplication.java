package com.product.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductStockApplication.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
        return args -> {
            for (int i = 0; i < 1000; i++) {
                kafkaTemplate.send("test", "data test"+i);
            }
        };
    }
}
