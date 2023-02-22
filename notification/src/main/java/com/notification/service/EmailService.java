package com.notification.service;

import com.notification.request.dto.MessageDTO;

public interface EmailService {
    void sendEmail(MessageDTO messageDTO);

    MessageDTO getAccountKafka(MessageDTO messageDTO);
}
