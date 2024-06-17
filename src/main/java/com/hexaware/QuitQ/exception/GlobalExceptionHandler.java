package com.hexaware.QuitQ.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class, CartItemNotFound.class, CategoryNotFoundException.class,
            CustomerException.class, CustomerNotFoundException.class, LoginException.class, OrderException.class,
            ProductNotFoundException.class, SellerException.class, SellerNotFoundException.class})
    public ResponseEntity<String> handleCustomExceptions(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
