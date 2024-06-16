package com.michaelcaxias.catalogs.api.src.domain.services.catalogs.mappers;

import com.michaelcaxias.catalogs.api.src.models.BaseCatalog;
import com.michaelcaxias.catalogs.api.src.models.Catalog;
import com.michaelcaxias.catalogs.api.src.models.CatalogItem;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogsConsumerMapper {
    BaseCatalog map(final Integer ownerID, final List<Catalog> catalog);

    @Mapping(target = "category_title", source = "category.title")
    @Mapping(target = "category_description", source = "category.description")
    Catalog mapCatalog(final Category category, final List<CatalogItem> items);

    List<CatalogItem> mapItem(final List<Product> products);
}
