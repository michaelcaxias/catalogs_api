package com.michaelcaxias.catalogs.api.src.domain.service.categories.impl;

import com.michaelcaxias.catalogs.api.src.domain.service.categories.CategoriesService;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository repository;

    @Override
    public Category registerCategory(Category category) {
        return repository.insert(category);
    }
}
