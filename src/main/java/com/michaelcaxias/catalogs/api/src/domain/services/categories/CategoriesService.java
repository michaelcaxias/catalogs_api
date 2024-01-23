package com.michaelcaxias.catalogs.api.src.domain.services.categories;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.models.Category;

import java.util.List;

public interface CategoriesService {
    Category findByID(String id);
    List<Category> findAll();
    Category save(CategoryDto category);
    Category updateByID(String id, CategoryDto category);
}
