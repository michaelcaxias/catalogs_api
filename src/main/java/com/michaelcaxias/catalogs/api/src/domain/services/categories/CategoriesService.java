package com.michaelcaxias.catalogs.api.src.domain.services.categories;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.models.Category;

import java.util.List;

public interface CategoriesService {
    Category getCategoryByID(String id);
    List<Category> getAllCategories();
    Category registerCategory(CategoryDto category);
    Category updateCategory(String id, CategoryDto category);
}
