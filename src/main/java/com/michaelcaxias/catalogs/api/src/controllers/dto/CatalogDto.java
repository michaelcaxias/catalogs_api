package com.michaelcaxias.catalogs.api.src.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record CatalogDto(
        @NotNull(message = "Owner Id is required")
        @JsonProperty("owner_id")
        Integer ownerID
) {
}
