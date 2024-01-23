package com.michaelcaxias.catalogs.api.src.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Document(collection = "categories")
public record Category(
    @MongoId
    String id,
    String title,
    Integer owner,
    String description
) {
}
