package com.account.entity;

import org.apache.kafka.common.protocol.types.Field;
/*
* @author: ThatND
* @since: 21/2/2023 4:24 PM
* @description:  Thông báo
* @update:
*
* */
public class MessageDTO {
    private String to;
    private String toName;
    private String subject;
    private String content;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageDTO() {
    }

    public MessageDTO(String to, String toName, String subject, String content) {
        this.to = to;
        this.toName = toName;
        this.subject = subject;
        this.content = content;
    }
}
