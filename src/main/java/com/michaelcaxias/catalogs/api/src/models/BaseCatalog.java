package com.michaelcaxias.catalogs.api.src.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record BaseCatalog(
        @JsonProperty("owner_id")
        Number ownerID,
        List<Catalog> catalog
) {
}
