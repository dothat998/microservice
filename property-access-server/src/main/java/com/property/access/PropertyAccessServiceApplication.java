package com.property.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@SpringBootApplication
@EnableConfigurationProperties
public class PropertyAccessServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PropertyAccessServiceApplication.class, args);
    }
}
