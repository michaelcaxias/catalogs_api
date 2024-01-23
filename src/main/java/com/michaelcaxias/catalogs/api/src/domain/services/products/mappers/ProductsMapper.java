package com.michaelcaxias.catalogs.api.src.domain.services.products.mappers;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.controllers.dto.ProductDto;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductsMapper {
    Product map(ProductDto product);

    @Mapping(target = "title", source = "product.title")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "ownerId", source = "product.ownerId")
    @Mapping(target = "category", source = "category")
    Product map(ProductDto product, Category category);
    Product map(String id, ProductDto product);
}
