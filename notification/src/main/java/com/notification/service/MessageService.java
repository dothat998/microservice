package com.notification.service;

import com.notification.request.dto.MessageDTO;

public interface MessageService {
    void sendEmail(MessageDTO messageDTO);
}


