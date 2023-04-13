package com.product.stock.dto;

public class MessageRequest {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageRequest() {
    }

    public MessageRequest(String message) {
        this.message = message;
    }
}
