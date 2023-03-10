package com.notification.service.impl;

import com.notification.request.dto.AccountDTO;
import com.notification.request.dto.MessageDTO;
import com.notification.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("dothat998@gmail.com")
    private String from;

    @Override
    @Async
    public void sendEmail(MessageDTO messageDTO) {
        try {
            logger.info("START............Sending Email!");
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());

            //load template email with content
            Context context = new Context();
            context.setVariable("name", messageDTO.getToName());
            context.setVariable("content", messageDTO.getContent());
            String html = templateEngine.process("welcome-email", context);

            //send email
            helper.setTo(messageDTO.getTo());
            helper.setText(html, true);
            helper.setSubject(messageDTO.getSubject());
            helper.setFrom(from);
            javaMailSender.send(message);

            logger.info("END........Email sent success~~~~~");
        } catch (MessagingException e) {
            logger.error("Email sent with error:" + e.getMessage());
        }
    }

    @Override
    public List<AccountDTO> getAccountKafka() {
        List<AccountDTO> accountDTOS =new ArrayList<>();
        return accountDTOS;
    }


}
