package com.michaelcaxias.catalogs.api.src.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CategoryDto(
    @NotBlank(message = "Title is required")
    String title,
    @NotNull(message = "Owner is required")
    @JsonProperty("owner_id")
    Integer ownerID,
    @NotBlank(message = "Description is required")
    String description
) {
}
