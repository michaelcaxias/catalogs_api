package com.michaelcaxias.catalogs.api.src.domain.services.categories;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.domain.services.EntityService;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.mappers.CategoriesMapper;
import com.michaelcaxias.catalogs.api.src.exceptions.NotFoundException;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.repositories.database.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService implements EntityService<Category, CategoryDto> {
    @Autowired
    private CategoriesRepository repository;

    @Autowired
    private CategoriesMapper mapper;

    @Override
    public Category findByID(String id) {
        final var category = repository.findById(id);

        if (category.isEmpty()) {
            throw new NotFoundException("Category not found");
        }

        return category.get();
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category save(final CategoryDto category) {
        final var categoryModel = mapper.map(category);

        return repository.insert(categoryModel);
    }

    @Override
    public Category updateByID(final String id, final CategoryDto category) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Category not found");
        }

        final var categoryModel = mapper.map(id, category);

        return repository.save(categoryModel);
    }
}
