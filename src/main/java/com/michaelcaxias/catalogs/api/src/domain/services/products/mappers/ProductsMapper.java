package com.michaelcaxias.catalogs.api.src.domain.services.products.mappers;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.controllers.dto.ProductDto;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductsMapper {
    Product map(ProductDto category);
    Product map(String id, ProductDto category);
}
