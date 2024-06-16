package com.michaelcaxias.catalogs.api.src.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class ApiException extends RuntimeException {
    private final String code;
    private final String message;
    private final Integer status;

    public ApiException(String message, HttpStatus httpStatus) {
        this.code = httpStatus.name();
        this.message = message;
        this.status = httpStatus.value();
    }
}
