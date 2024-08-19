package com.billypunisher.desafio.dto.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Getter
public class ValidationError extends StandardError {

    private Set<FieldError> fieldErrors = new HashSet<>();


    public ValidationError(Instant instant, Integer status, String error, String message, String path) {
        super(instant, status, error, message, path);
    }


    public void addFieldError(FieldError fieldError) {
        fieldErrors.add(fieldError);
    }

    public Set<FieldError> getFieldErrors() {
        return fieldErrors;
    }

}
