package com.michaelcaxias.catalogs.api.src.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDto(
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank(message = "Description is required")
        String description,
        @NotNull(message = "Owner Id is required")
        @JsonProperty("owner_id")
        Integer ownerID,
        @NotNull(message = "Price is required")
        BigDecimal price,
        @NotBlank(message = "Category Id is required")
        @JsonProperty("category_id")
        String categoryID
) {
}
