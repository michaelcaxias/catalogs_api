package com.michaelcaxias.catalogs.api.src.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ApiException extends RuntimeException {
    private final String code;
    private final String message;
    private final Integer status;
}
