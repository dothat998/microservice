package com.spring.exception;


import com.sib.co.exception.ErrorResponse;
import com.sib.co.exception.NotFoundExceptionCustom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
public class CustomException {
    @ExceptionHandler(NotFoundExceptionCustom.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public com.sib.co.exception.ErrorResponse handlerNotFoundEx(NotFoundExceptionCustom ex, WebRequest request){
        System.out.println(" CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
                " ");
        return new com.sib.co.exception.ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
    }
    @ExceptionHandler(NullPointerException.class) // exception handled
    public ResponseEntity<com.sib.co.exception.ErrorResponse> handleNullPointerExceptions(
            Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return new ResponseEntity<>(
                new com.sib.co.exception.ErrorResponse(
                        status,
                        e.getMessage()
                ),
                status
        );
    }

    // fallback method
    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<com.sib.co.exception.ErrorResponse> handleExceptions(
            Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage()
                ),
                status
        );
    }
}
