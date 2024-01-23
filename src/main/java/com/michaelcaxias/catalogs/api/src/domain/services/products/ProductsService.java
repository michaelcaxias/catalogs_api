package com.michaelcaxias.catalogs.api.src.domain.services.products;

import com.michaelcaxias.catalogs.api.src.controllers.dto.ProductDto;
import com.michaelcaxias.catalogs.api.src.domain.services.EntityService;
import com.michaelcaxias.catalogs.api.src.domain.services.products.mappers.ProductsMapper;
import com.michaelcaxias.catalogs.api.src.exceptions.NotFoundException;
import com.michaelcaxias.catalogs.api.src.models.Product;
import com.michaelcaxias.catalogs.api.src.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements EntityService<Product, ProductDto> {
    @Autowired
    private ProductsRepository repository;

    @Autowired
    private ProductsMapper mapper;

    @Override
    public Product findByID(final String id) {
        final var product = repository.findById(id);

        if (product.isEmpty()) {
            throw new NotFoundException("Product not found");
        }

        return product.get();
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product save(final ProductDto product) {
        final var productModel = mapper.map(product);

        return repository.insert(productModel);
    }

    @Override
    public Product updateByID(final String id, final ProductDto product) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Product not found");
        }

        final var productModel = mapper.map(id, product);

        return repository.save(productModel);
    }
}
