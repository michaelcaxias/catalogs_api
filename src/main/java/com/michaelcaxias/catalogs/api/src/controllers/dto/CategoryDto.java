package com.michaelcaxias.catalogs.api.src.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CategoryDto(
    @NotBlank(message = "Title is required")
    String title,

    @NotNull(message = "Owner is required")
    Integer owner,
    @NotBlank(message = "Description is required")
    String description
) {
}
