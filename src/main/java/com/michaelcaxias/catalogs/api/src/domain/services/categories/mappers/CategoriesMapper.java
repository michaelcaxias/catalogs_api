package com.michaelcaxias.catalogs.api.src.domain.services.categories.mappers;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {
    Category map(CategoryDto category);
}
