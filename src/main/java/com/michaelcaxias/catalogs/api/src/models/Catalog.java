package com.michaelcaxias.catalogs.api.src.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record Catalog(
        String category_title,
        String category_description,
        List<CatalogItem> items
) {
}
