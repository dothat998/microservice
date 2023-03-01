package com.account;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class,args);
    }
    @Bean
    NewTopic notification(){
        //name toppic + so luong partition + số lượng bản replication partition thường thì bằng số lượng con broker (do chạy local 1 broker server nên = 1)
        return new NewTopic("notification",2,(short) 1);
    }



    @Bean
    NewTopic statistic(){
        return new NewTopic("statistic",1,(short) 1);
    }
}
