package com.example.demo.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControlAdvice {
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        return "error";
    }
}
