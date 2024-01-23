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
    public Category save(final @RequestBody @Valid CategoryDto category) {
        return service.save(category);
    }

    @PutMapping("/categories/{id}")
    public Category updateById(
            final @PathVariable("id") String id,
            final @RequestBody @Valid CategoryDto category
    ) {
        return service.updateByID(id, category);
    }

    @GetMapping("/categories/{id}")
    public Category findByID(final @PathVariable("id") String id) {
        return service.findByID(id);
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return service.findAll();
    }
}
