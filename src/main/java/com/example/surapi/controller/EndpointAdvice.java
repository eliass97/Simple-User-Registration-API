package com.example.surapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.surapi.exception.ExceptionForm;
import com.example.surapi.exception.SystemUserException;

@ControllerAdvice
public class EndpointAdvice {

    @ExceptionHandler(SystemUserException.class)
    public ResponseEntity<ExceptionForm> CommonExceptionHandler(SystemUserException exception, HttpServletRequest request) {
        ExceptionForm exceptionform = new ExceptionForm(exception.getTimestamp(),
                exception.getStatus(),
                exception.getClass().getCanonicalName(),
                exception.getMessage(),
                request.getServletPath());
        return new ResponseEntity<>(exceptionform, exception.getStatus());
    }
}
