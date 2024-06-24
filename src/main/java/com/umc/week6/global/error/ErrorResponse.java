package com.umc.week6.global.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

@Builder
@Getter
public class ErrorResponse {
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<ValidationError> errors;


    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class ValidationError {
        private final String field;
        private final String message;

        public static ValidationError of(final FieldError fieldError) {
            return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }

        public static ValidationError of(final ConstraintViolation<?> constraintViolation) {
            return ValidationError.builder()
                    .field(getFieldName(constraintViolation.getPropertyPath().toString()))
                    .message(constraintViolation.getMessage())
                    .build();
        }

        private static String getFieldName(String path) {
            String[] dividedPath = path.split("[.]");
            return dividedPath[dividedPath.length - 1];
        }
    }
}
