package com.michaelcaxias.catalogs.api.src.controllers.dto;

import lombok.Builder;

@Builder
public record CategoryDto(
    String title,
    Integer owner,
    String description
) {
}
