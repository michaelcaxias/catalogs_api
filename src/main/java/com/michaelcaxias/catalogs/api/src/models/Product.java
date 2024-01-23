package com.michaelcaxias.catalogs.api.src.models;


import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Document(collection = "products")
public record Product(
        @MongoId
        String id
) {
}
