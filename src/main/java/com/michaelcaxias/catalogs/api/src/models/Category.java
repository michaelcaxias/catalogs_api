package com.michaelcaxias.catalogs.api.src.models;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "categories")
public record Category(
    String title,
    Integer owner,
    String description
) {
}
