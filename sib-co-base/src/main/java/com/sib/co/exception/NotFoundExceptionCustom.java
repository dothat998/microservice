package com.sib.co.exception;

public class NotFoundExceptionCustom  extends RuntimeException{
    public NotFoundExceptionCustom(String message){
        super(message);
    }
}
