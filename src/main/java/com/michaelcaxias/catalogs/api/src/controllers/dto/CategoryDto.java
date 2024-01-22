package com.michaelcaxias.catalogs.api.src.controllers.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record CategoryDto(
    @NonNull
    String title,
    @NonNull
    Integer owner,
    @NonNull
    String description
) {
}
