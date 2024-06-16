package com.michaelcaxias.catalogs.api.src.repositories.database;

import com.michaelcaxias.catalogs.api.src.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository extends MongoRepository<Category, String> {
    Optional<Category> findById(String id);
    List<Category> findByOwnerID(Integer ownerID);
}
