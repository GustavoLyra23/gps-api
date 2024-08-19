package com.billypunisher.desafio.controllers.handler;

import com.billypunisher.desafio.dto.error.FieldError;
import com.billypunisher.desafio.dto.error.StandardError;
import com.billypunisher.desafio.dto.error.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleValidationException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError validationError = new ValidationError(Instant.now(), status.value(), e.getMessage(),
                "UNPROCESSABLE_ENTITY", request.getRequestURI());
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            validationError.addFieldError(new FieldError(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.status(status).body(validationError);
    }

}



