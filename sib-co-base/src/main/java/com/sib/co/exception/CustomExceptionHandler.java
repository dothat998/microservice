package com.sib.co.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundExceptionCustom.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerNotFoundEx(NotFoundExceptionCustom ex, WebRequest request){
//        return new ErrorResponse(HttpStatus.NOT_FOUND,"Khong tim thay id");
        return new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
    }
}
