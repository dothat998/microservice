package com.notification.service.impl;

import com.notification.request.dto.MessageDTO;
import com.notification.service.EmailService;
import com.notification.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {


    Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private EmailService emailService;

    @KafkaListener(id = "notificationGroup", topics = "notification")
    public void listen(MessageDTO messageDTO) {
        //Đọc lại event và gán lại vào đối tượng
        logger.info("Received: " + messageDTO.getTo());
        emailService.sendEmail(messageDTO);
    }

    @KafkaListener(id = "notificationGroup2", topics = "notification")
    public void getAccount(MessageDTO messageDTO) {
        emailService.getAccountKafka(messageDTO);
    }
}
