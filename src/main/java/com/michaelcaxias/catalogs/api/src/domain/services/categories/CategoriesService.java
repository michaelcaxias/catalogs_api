package com.michaelcaxias.catalogs.api.src.domain.services.categories;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.models.Category;

public interface CategoriesService {
    Category registerCategory(CategoryDto category);
}
