package com.notification.controller;

import com.notification.request.dto.MessageDTO;
import com.notification.service.MessageService;
import com.notification.service.impl.MessageServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gui email thong bao
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private MessageServiceImpl messageService;

    @PostMapping("/send-notification")
    public void sendNotification(@RequestBody MessageDTO messageDTO){
        messageService.listen(messageDTO);
    }

    @GetMapping("/list")
    public void getAccount(){
        messageService.getAccount();
    }
}
