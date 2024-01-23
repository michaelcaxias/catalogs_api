package com.michaelcaxias.catalogs.api.src.exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(final String message) {
        super(message);
    }
}
