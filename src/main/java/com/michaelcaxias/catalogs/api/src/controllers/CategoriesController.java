package com.michaelcaxias.catalogs.api.src.controllers;

import com.michaelcaxias.catalogs.api.src.domain.service.categories.CategoriesService;
import com.michaelcaxias.catalogs.api.src.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.michaelcaxias.catalogs.api.src.config.ResourceConfig.ROOT_PATH;

@RestController
@RequestMapping(ROOT_PATH)
public class CategoriesController {
    @Autowired
    private CategoriesService service;


    @PostMapping("/categories")
    public Category registerCategory(@RequestBody Category category) {
        return service.registerCategory(category);
    }
}
