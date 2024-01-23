package com.michaelcaxias.catalogs.api.src.controllers;

import com.michaelcaxias.catalogs.api.src.controllers.dto.ProductDto;
import com.michaelcaxias.catalogs.api.src.domain.services.EntityService;
import com.michaelcaxias.catalogs.api.src.models.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.michaelcaxias.catalogs.api.src.config.ResourceConfig.ROOT_PATH;

@RestController
@RequestMapping(ROOT_PATH)
@Validated
public class ProductsController {
    @Autowired
    private EntityService<Product, ProductDto> service;

    @PostMapping("/products")
    public Product save(final @RequestBody @Valid ProductDto category) {
        return service.save(category);
    }

    @PutMapping("/products/{id}")
    public Product updateById(
            final @PathVariable("id") String id,
            final @RequestBody @Valid ProductDto category
    ) {
        return service.updateByID(id, category);
    }

    @GetMapping("/products/{id}")
    public Product findByID(final @PathVariable("id") String id) {
        return service.findByID(id);
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return service.findAll();
    }
}
