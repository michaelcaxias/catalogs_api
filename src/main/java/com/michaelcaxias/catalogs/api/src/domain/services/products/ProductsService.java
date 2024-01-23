package com.michaelcaxias.catalogs.api.src.domain.services.products;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.controllers.dto.ProductDto;
import com.michaelcaxias.catalogs.api.src.domain.services.EntityService;
import com.michaelcaxias.catalogs.api.src.domain.services.products.mappers.ProductsMapper;
import com.michaelcaxias.catalogs.api.src.exceptions.ApiException;
import com.michaelcaxias.catalogs.api.src.exceptions.NotFoundException;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.models.Product;
import com.michaelcaxias.catalogs.api.src.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductsService implements EntityService<Product, ProductDto> {
    @Autowired
    private ProductsRepository repository;

    @Autowired
    private ProductsMapper mapper;

    @Autowired
    private EntityService<Category, CategoryDto> categoryService;

    private static final String NOT_FOUND_MESSAGE = "Product not found";
    private static final String BAD_REQUEST_CODE = "bad_request";
    private static final String CATEGORY_NOT_ASSOCIATED = "Category and Product must have the same owner";

    @Override
    public Product findByID(final String id) {
        final var product = repository.findById(id);

        if (product.isEmpty()) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }

        return product.get();
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product save(final ProductDto product) {
        final var category = categoryService.findByID(product.categoryId());

        if (Objects.isNull(category)) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }

        if (!product.ownerId().equals(category.ownerId())) {
            throw new ApiException(BAD_REQUEST_CODE, CATEGORY_NOT_ASSOCIATED, HttpStatus.BAD_REQUEST.value());
        }

        // TODO: the field category must be updated in the catalog consumer service, updating json and this field
        // TODO: a message will be sent when updated/saved with the values

        final var productModel = mapper.map(product, category);

        return repository.insert(productModel);
    }

    @Override
    public Product updateByID(final String id, final ProductDto product) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }

        final var productModel = mapper.map(id, product);

        return repository.save(productModel);
    }
}
