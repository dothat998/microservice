package com.sib.co.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SibCoRuntimeException extends RuntimeException {

    private final String errorCode;

    public SibCoRuntimeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public SibCoRuntimeException(String message) {
        super(message);
        errorCode = "";
    }

    public SibCoRuntimeException(Throwable cause) {
        super(cause);
        this.errorCode = "";
    }

    public String getErrorCode() {
        if (errorCode == null) {
            return "";
        }
        return errorCode.trim();
    }
}
