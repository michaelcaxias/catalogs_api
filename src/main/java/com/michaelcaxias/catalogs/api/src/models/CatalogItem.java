package com.michaelcaxias.catalogs.api.src.models;

import java.math.BigDecimal;

public record CatalogItem(
        String title,
        String description,
        BigDecimal price
) {
}
