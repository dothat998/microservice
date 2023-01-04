package com.notification.controller;

import com.notification.request.dto.MessageDTO;
import com.notification.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Gui email thong bao
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send-notification")
    public void sendNotification(@RequestBody MessageDTO messageDTO){
        messageService.sendEmail(messageDTO);
    }
}
