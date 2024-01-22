package com.michaelcaxias.catalogs.api.src.controllers;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.CategoriesService;
import com.michaelcaxias.catalogs.api.src.models.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.michaelcaxias.catalogs.api.src.config.ResourceConfig.ROOT_PATH;

@RestController
@RequestMapping(ROOT_PATH)
@Validated
public class CategoriesController {
    @Autowired
    private CategoriesService service;

    @PostMapping("/categories")
    public Category registerCategory(final @RequestBody @Valid CategoryDto category) {
        return service.registerCategory(category);
    }
}
