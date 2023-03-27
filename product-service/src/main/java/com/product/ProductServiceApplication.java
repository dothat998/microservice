package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {
    //    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceApplication.class);
//    static {
//        // for localhost testing only
//        LOG.warn("Will now disable hostname check in SSL, only to be used during development");
//        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);
//    }
//    public static void main(String[] args) {
//
////        ConfigurableApplicationContext ctx = SpringApplication.run(ProductServiceApplication.class, args);
//        SpringApplication.run(ProductServiceApplication.class, args);
////        LOG.info("Connected to RabbitMQ at: {}", ctx.getEnvironment().getProperty("spring.rabbitmq.host"));
//    }
//}
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}