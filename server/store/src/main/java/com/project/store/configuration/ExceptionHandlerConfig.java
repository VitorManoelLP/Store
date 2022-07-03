package com.project.store.configuration;

import com.project.store.configuration.exception.IllegalArgumentExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleException(IllegalArgumentException illegal) {
        return new ResponseEntity<>(IllegalArgumentExceptionDTO.of(illegal), HttpStatus.BAD_REQUEST);
    }
    
}
