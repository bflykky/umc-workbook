package com.umc.week6.global.error;

import com.umc.week6.global.error.code.GlobalErrorCode;
import com.umc.week6.global.error.exception.BusinessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    // 비즈니스 로직에서 발생하는 예외 처리
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<Object> handleBusinessException(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();
        return handleExceptionInternal(errorCode);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException e) {
        ErrorCode errorCode = GlobalErrorCode.INVALID_PARAMETER;
        return handleExceptionInternal(errorCode, e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        ErrorCode errorCode = GlobalErrorCode.INVALID_PARAMETER;
        return handleExceptionInternal(e, errorCode);
    }

    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode));
    }

    private ErrorResponse makeErrorResponse(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .httpStatus(errorCode.getHttpStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();
    }

    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode, String message) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode, message));
    }

    private Object makeErrorResponse(ErrorCode errorCode, String message) {
        return ErrorResponse.builder()
                .httpStatus(errorCode.getHttpStatus())
                .code(errorCode.getCode())
                .message(message)
                .build();
    }

    private ResponseEntity<Object> handleExceptionInternal(BindException e, ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(makeErrorResponse(e, errorCode));
    }

    private Object makeErrorResponse(BindException e, ErrorCode errorCode) {
        final List<ErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> ErrorResponse.ValidationError.of(fieldError))
                .collect(Collectors.toList());

        return ErrorResponse.builder()
                .httpStatus(errorCode.getHttpStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .errors(validationErrorList)
                .build();
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatusCode statusCode, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode.value());

        return ResponseEntity
                .status(httpStatus)
                .body(makeErrorResponse(GlobalErrorCode.UNDEFINED_ERROR, httpStatus, ex.getMessage()));

    }

    private Object makeErrorResponse(ErrorCode errorCode, HttpStatus httpStatus, String message) {
        return ErrorResponse.builder()
                .httpStatus(httpStatus)
                .code(errorCode.getCode())
                .message(message)
                .build();
    }
}
