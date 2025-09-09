package com.communication2.communication2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = {TestCommunicationException.class})
    public ResponseEntity<?> handleTestCommunicationException(TestCommunicationException testCommunicationException) {
        return new ResponseEntity<>(testCommunicationException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
