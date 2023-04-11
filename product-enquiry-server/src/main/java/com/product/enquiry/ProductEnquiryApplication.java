package com.product.enquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
* @author: ThatND
* @since: 11/4/2023 4:23 PM
* @description:  Yeu cau san pham
* @update:
*
* */

@SpringBootApplication
@EnableFeignClients("com.product.enquiry")
public class ProductEnquiryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductEnquiryApplication.class,args);
    }}
