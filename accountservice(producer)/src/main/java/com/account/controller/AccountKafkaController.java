package com.account.controller;

import com.account.entity.AccountDTO;
import com.account.entity.MessageDTO;
import com.account.entity.StatisticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/account/kafka")
public class AccountKafkaController {
    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;


    @PostMapping("/new")
    public AccountDTO create(@RequestBody AccountDTO accountDTO){
        StatisticDTO statisticDTO = new StatisticDTO("Account" +accountDTO.getEmail()+" is created ", new Date());
        // gửi thông báo
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTo(accountDTO.getEmail());
        messageDTO.setToName(accountDTO.getName());
        messageDTO.setSubject("Day la subject");
        messageDTO.setContent("Day la content");
        kafkaTemplate.send("notification",messageDTO);
        kafkaTemplate.send("statistic",statisticDTO);
        return accountDTO;
    }
}
