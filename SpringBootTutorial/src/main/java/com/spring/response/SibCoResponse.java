package com.spring.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class SibCoResponse<T>{
    private String code;
    private String message;
    private String warningCode;
    private T data;

    public SibCoResponse() {
        // Contructor
    }

    public SibCoResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public SibCoResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWarningCode() {
        return warningCode;
    }

    public void setWarningCode(String warningCode) {
        this.warningCode = warningCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
