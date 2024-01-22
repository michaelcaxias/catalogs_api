package com.michaelcaxias.catalogs.api.unit.services;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CategoryDto;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.CategoriesService;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.impl.CategoriesServiceImpl;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.mappers.CategoriesMapper;
import com.michaelcaxias.catalogs.api.src.domain.services.categories.mappers.CategoriesMapperImpl;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.repositories.CategoriesRepository;
import com.michaelcaxias.catalogs.api.unit.UnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class CategoriesServiceTest extends UnitTest {

    @InjectMocks
    private CategoriesServiceImpl service;

    @Mock
    private CategoriesRepository repository;

    @Mock
    private CategoriesMapperImpl mapper;

    @Test
    public void when_send_valid_category_should_return_category() {
        // Arrange
        doReturn(getValidCategory()).when(repository).insert(any(Category.class));
        doReturn(getValidCategory()).when(mapper).map(any(CategoryDto.class));
        // Act
        final var response = service.registerCategory(getValidCategoryDto());
        // Assert
        assertEquals(getValidCategory(), response);
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
