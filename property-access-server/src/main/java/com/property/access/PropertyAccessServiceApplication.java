package com.property.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@SpringBootApplication
//@EnableSwagger2
@EnableConfigurationProperties
public class PropertyAccessServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PropertyAccessServiceApplication.class, args);
    }

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.
//                        basePackage("com.techefx.microservices.techefxpropertyaccessservice.controller"))
//                .build();
//    }
}
