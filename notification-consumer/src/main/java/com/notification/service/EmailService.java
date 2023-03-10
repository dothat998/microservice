package com.notification.service;

import com.notification.request.dto.AccountDTO;
import com.notification.request.dto.MessageDTO;

import java.util.List;

public interface EmailService {
    void sendEmail(MessageDTO messageDTO);

    List<AccountDTO> getAccountKafka();
}
