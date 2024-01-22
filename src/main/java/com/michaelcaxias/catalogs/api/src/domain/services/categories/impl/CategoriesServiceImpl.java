package com.michaelcaxias.catalogs.api.src.domain.services.categories.impl;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.CategoriesService;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.mappers.CategoriesMapper;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository repository;

    @Autowired
    private CategoriesMapper mapper;

    @Override
    public Category registerCategory(final CategoryDto category) {
        final var categoryModel = mapper.map(category);

        return repository.insert(categoryModel);
    }
}
