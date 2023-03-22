package com.account.config.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigKafka {
    @Bean
    NewTopic testTopic(){
        //name toppic + so luong partition + số lượng bản replication partition thường thì bằng số lượng con broker (do chạy local 1 broker server nên = 1)
        return new NewTopic("dothat",1,(short) 1);
    }

    @Bean
    NewTopic notification(){
        //name toppic + so luong partition + số lượng bản replication partition
        // thường thì bằng số lượng con broker (do chay local 1 broker server nên = 1)
        return new NewTopic("notification",2,(short) 1);
    }


    @Bean
    NewTopic statistic(){
        return new NewTopic("statistic",1,(short) 1);
    }

}
