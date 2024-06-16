package com.michaelcaxias.catalogs.api.src.domain.services.products;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.controllers.dto.ProductDto;
import com.michaelcaxias.catalogs.api.src.domain.services.EntityService;
import com.michaelcaxias.catalogs.api.src.domain.services.products.mappers.ProductsMapper;
import com.michaelcaxias.catalogs.api.src.exceptions.ApiException;
import com.michaelcaxias.catalogs.api.src.exceptions.NotFoundException;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.models.Product;
import com.michaelcaxias.catalogs.api.src.repositories.database.ProductsRepository;
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

    @Autowired
    private ProductsNotifierService notifierService;

    private static final String NOT_FOUND_MESSAGE = "Product not found";
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
        final var category = categoryService.findByID(product.categoryID());

        if (Objects.isNull(category)) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }

        if (!product.ownerID().equals(category.ownerID())) {
            throw new ApiException(HttpStatus.FORBIDDEN.name(), CATEGORY_NOT_ASSOCIATED, HttpStatus.FORBIDDEN.value());
        }

        final var productModel = mapper.map(product);

        final Product productSaved = repository.insert(productModel);

        notifierService.notify(product.ownerID());

        return productSaved;
    }

    @Override
    public Product updateByID(final String id, final ProductDto product) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }

        final var productModel = mapper.map(id, product);

        final Product productSaved = repository.save(productModel);

        notifierService.notify(product.ownerID());

        return productSaved;
    }
}
