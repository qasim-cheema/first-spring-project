package com.example.demo;

import org.springframework.http.HttpStatus;

public class ReadfileException extends RuntimeException {
    private HttpStatus httpStatus;
    public ReadfileException() {
    }

    public ReadfileException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
