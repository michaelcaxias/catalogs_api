package com.michaelcaxias.catalogs.api.src.repositories;

import com.michaelcaxias.catalogs.api.src.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductsRepository extends MongoRepository<Product, String> {
    Optional<Product> findById(String id);
}
