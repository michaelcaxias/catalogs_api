package com.michaelcaxias.catalogs.api.src.config;


import com.michaelcaxias.catalogs.api.src.exceptions.ApiError;
import com.michaelcaxias.catalogs.api.src.exceptions.ApiException;
import com.michaelcaxias.catalogs.api.src.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        final var apiException = ApiError.builder()
                .code("bad_request")
                .message(String.valueOf(errorMessages))
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(apiException.status()).body(apiException);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(final NotFoundException e) {
        final var apiException = ApiError.builder()
                .code("not_found")
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(apiException.status()).body(apiException);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleNotFoundException(final ApiException e) {
        final var apiException = ApiError.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .status(e.getStatus())
                .build();

        return ResponseEntity.status(apiException.status()).body(apiException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(final Exception e) {
        final var apiException = ApiError.builder()
                .code("internal_server_error")
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity.status(apiException.status()).body(apiException);
    }
}
