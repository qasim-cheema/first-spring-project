package com.example.demo.controlers;

import com.example.demo.ProductNotfoundException;
import com.example.demo.ReadfileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception(ProductNotfoundException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ReadfileException.class)
    public ResponseEntity<Object> exception(ReadfileException exception) {
        return new ResponseEntity<>("Problem With file", exception.getHttpStatus());

    }
    // Add some more user define exceptions


}
