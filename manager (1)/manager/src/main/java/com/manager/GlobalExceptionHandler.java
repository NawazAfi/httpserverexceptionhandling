package com.manager;

//below code work upto internal server excuaption handling

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(AccountService.ResourceNotFoundException.class)
//    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(AccountService.ResourceNotFoundException ex) {
//        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(AccountService.InsufficientFundsException.class)
//    public ResponseEntity<Map<String, Object>> handleInsufficientFundsException(AccountService.InsufficientFundsException ex) {
//        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
//        return buildResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    private ResponseEntity<Map<String, Object>> buildResponse(String message, HttpStatus status) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("message", message);
//        response.put("valid", false);
//        response.put("status", status);
//        return ResponseEntity.status(status).body(response);
//    }
//}

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountService.ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(AccountService.ResourceNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountService.InsufficientFundsException.class)
    public ResponseEntity<Map<String, Object>> handleInsufficientFundsException(AccountService.InsufficientFundsException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountService.NetworkException.class)
    public ResponseEntity<Map<String, Object>> handleNetworkException(AccountService.NetworkException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
        return buildResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Map<String, Object>> buildResponse(String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("valid", false);
        response.put("status", status);
        return ResponseEntity.status(status).body(response);
    }
}

