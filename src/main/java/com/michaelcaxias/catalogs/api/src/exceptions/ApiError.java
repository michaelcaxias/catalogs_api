package com.michaelcaxias.catalogs.api.src.exceptions;

import lombok.Builder;

@Builder
public record ApiError(
        String code,
        String message,
        Integer status
) {
}
