package com.communication.communication.exception;

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

    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity<?> handleUserException(UserException userException) {
        return new ResponseEntity<>(userException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
