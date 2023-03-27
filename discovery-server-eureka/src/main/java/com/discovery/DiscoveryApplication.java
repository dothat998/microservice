package com.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
* @author: ThatND
* @since: 8/3/2023 3:56 PM
* @description:  Discovery - Server
* SERVICE DISCOVERY (EUREKA) : đóng vai trò đăng kí những service nhỏ vào trong hệ thống.
 * @update:
*
* */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class,args);
    }
}
