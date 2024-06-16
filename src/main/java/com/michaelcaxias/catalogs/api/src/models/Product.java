package com.michaelcaxias.catalogs.api.src.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Builder
@Document(collection = "products")
public record Product(
        @MongoId
        String id,
        String title,
        String description,
        @JsonProperty("owner_id")
        Integer ownerID,
        BigDecimal price,
        @JsonProperty("category_id")
        String categoryID
) {
}
