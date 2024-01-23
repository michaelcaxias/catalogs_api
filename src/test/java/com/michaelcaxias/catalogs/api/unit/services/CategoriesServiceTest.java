package com.michaelcaxias.catalogs.api.unit.services;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.impl.CategoriesServiceImpl;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.mappers.CategoriesMapperImpl;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.repositories.CategoriesRepository;
import com.michaelcaxias.catalogs.api.unit.UnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

public class CategoriesServiceTest extends UnitTest {

    @InjectMocks
    private CategoriesServiceImpl service;

    @Mock
    private CategoriesRepository repository;

    @Mock
    private CategoriesMapperImpl mapper;

    @Test
    public void when_send_valid_category_then_insert_and_return_category() {
        // Arrange
        doReturn(getValidCategory()).when(repository).insert(any(Category.class));
        doReturn(getValidCategory()).when(mapper).map(any(CategoryDto.class));
        // Act
        final var response = service.registerCategory(getValidCategoryDto());
        // Assert
        assertEquals(getValidCategory(), response);
    }

    @Test
    public void when_send_valid_category_then_update_and_return_category() {
        // Arrange
        doReturn(true).when(repository).existsById(anyString());
        doReturn(getValidCategory()).when(repository).save(any(Category.class));
        doReturn(getValidCategory()).when(mapper).map(anyString(), any(CategoryDto.class));
        // Act
        final var response = service.updateCategory("1", getValidCategoryDto());
        // Assert
        assertEquals(getValidCategory(), response);
    }

    @Test
    public void when_get_all_categories() {
        // Arrange
        doReturn(getValidCategories()).when(repository).findAll();
        // Act
        final var response = service.getAllCategories();
        // Assert
        assertEquals(getValidCategories(), response);
    }

    @Test
    public void when_category_exists_get_category_by_id() {
        // Arrange
        doReturn(Optional.of(getValidCategory())).when(repository).findById(anyString());
        // Act
        final var response = service.getCategoryByID("1");
        // Assert
        assertEquals(getValidCategory(), response);
    }

    private List<Category> getValidCategories() {
        return List.of(getValidCategory());
    }

    private CategoryDto getValidCategoryDto() {
        return CategoryDto.builder()
                .title("Category")
                .description("Category description")
                .owner(1)
                .build();
    }

    private Category getValidCategory() {
        return Category.builder()
                .title("Category")
                .description("Category description")
                .owner(1)
                .build();
    }
}
