package com.michaelcaxias.catalogs.api.unit.services;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.controllers.dto.ProductDto;
import com.michaelcaxias.catalogs.api.src.domain.services.EntityService;
import com.michaelcaxias.catalogs.api.src.domain.services.products.ProductsService;
import com.michaelcaxias.catalogs.api.src.domain.services.products.mappers.ProductsMapper;
import com.michaelcaxias.catalogs.api.src.exceptions.ApiException;
import com.michaelcaxias.catalogs.api.src.exceptions.NotFoundException;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.models.Product;
import com.michaelcaxias.catalogs.api.src.repositories.ProductsRepository;
import com.michaelcaxias.catalogs.api.unit.UnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

public class ProductsServiceTest extends UnitTest {

    @InjectMocks
    private ProductsService service;

    @Mock
    private ProductsRepository repository;

    @Mock
    private ProductsMapper mapper;

    @Mock
    private EntityService<Category, CategoryDto> categoryService;

    @Test
    public void when_send_valid_product_then_insert_and_return_product() {
        // Arrange
        doReturn(getValidCategory()).when(categoryService).findByID(anyString());
        doReturn(getValidProduct()).when(repository).insert(any(Product.class));
        doReturn(getValidProduct()).when(mapper).map(any(ProductDto.class));
        // Act
        final var response = service.save(getValidProductDto());
        // Assert
        assertEquals(getValidProduct(), response);
    }

    @Test
    public void when_send_product_with_not_found_category_then_throw_exception() {
        doReturn(null).when(categoryService).findByID(anyString());

        assertThrows(NotFoundException.class, () -> service.save(getValidProductDto()));
    }

    @Test
    public void when_send_category_with_different_owner_then_throw_exception() {
        doReturn(getCategoryWithDifferentOwner()).when(categoryService).findByID(anyString());

        assertThrows(ApiException.class, () -> service.save(getValidProductDto()));
    }

    @Test
    public void when_send_valid_product_then_update_and_return_product() {
        doReturn(true).when(repository).existsById(anyString());
        doReturn(getValidProduct()).when(repository).save(any(Product.class));
        doReturn(getValidProduct()).when(mapper).map(anyString(), any(ProductDto.class));

        final var response = service.updateByID("1", getValidProductDto());

        assertEquals(getValidProduct(), response);
    }

    @Test
    public void when_get_all_products() {
        doReturn(getValidProducts()).when(repository).findAll();

        final var response = service.findAll();

        assertEquals(getValidProducts(), response);
    }

    @Test
    public void when_product_exists_get_product_by_id() {
        doReturn(Optional.of(getValidProduct())).when(repository).findById(anyString());

        final var response = service.findByID("1");

        assertEquals(getValidProduct(), response);
    }

    private List<Product> getValidProducts() {
        return List.of(getValidProduct());
    }

    private ProductDto getValidProductDto() {
        return ProductDto.builder()
                .title("Product")
                .description("Product description")
                .ownerId(1)
                .categoryId("1")
                .build();
    }

    private Product getValidProduct() {
        return Product.builder()
                .title("Product")
                .description("Product description")
                .ownerId(1)
                .categoryId("1")
                .build();
    }

    private Category getValidCategory() {
        return Category.builder()
                .title("Category")
                .description("Category description")
                .ownerId(1)
                .build();
    }

    private Category getCategoryWithDifferentOwner() {
        return Category.builder()
                .title("Category")
                .description("Category description")
                .ownerId(2)
                .build();
    }
}
