package com.michaelcaxias.catalogs.api.src.repositories;

import com.michaelcaxias.catalogs.api.src.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriesRepository extends MongoRepository<Category, String> {
    Category findByOwner(String owner);
    Category insert(Category category);
}
