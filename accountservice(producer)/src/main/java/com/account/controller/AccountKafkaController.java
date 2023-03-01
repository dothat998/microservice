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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/account/kafka")
public class AccountKafkaController {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;


    @PostMapping("/new")
    public AccountDTO create(@RequestBody AccountDTO accountDTO) {
        StatisticDTO statisticDTO = new StatisticDTO("Account" + accountDTO.getEmail() + " is created ", new Date());
        // gửi thông báo
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTo(accountDTO.getEmail());
        messageDTO.setToName(accountDTO.getName());
        messageDTO.setSubject("Day la subject");
        messageDTO.setContent("Day la content");
        kafkaTemplate.send("notification", messageDTO);
        kafkaTemplate.send("statistic", statisticDTO);
        return accountDTO;
    }

    @PostMapping("/test")
    public List<AccountDTO> test(@RequestBody AccountDTO accountDTO) {

        List<AccountDTO> list = new ArrayList<>();

        AccountDTO dto = new AccountDTO();
        dto.setEmail(accountDTO.getEmail());
        dto.setName(accountDTO.getName());

        AccountDTO dto1 = new AccountDTO();
        dto1.setEmail(accountDTO.getEmail());
        dto1.setName(accountDTO.getName());

        list.add(dto1);
        list.add(dto);

        kafkaTemplate.send("dothat", list);

        return list;

    }
}
