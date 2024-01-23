package com.michaelcaxias.catalogs.api.src.controllers;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.CategoriesService;
import com.michaelcaxias.catalogs.api.src.models.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/categories/{id}")
    public Category updateCategory(
            final @PathVariable("id") String id,
            final @RequestBody @Valid CategoryDto category
    ) {
        return service.updateCategory(id, category);
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryByID(final @PathVariable("id") String id) {
        return service.getCategoryByID(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }
}
