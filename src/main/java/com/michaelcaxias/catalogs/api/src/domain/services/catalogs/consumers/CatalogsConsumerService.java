package com.michaelcaxias.catalogs.api.src.domain.services.catalogs.consumers;

import com.michaelcaxias.catalogs.api.src.domain.services.ConsumerService;
import com.michaelcaxias.catalogs.api.src.domain.services.catalogs.mappers.CatalogsConsumerMapper;
import com.michaelcaxias.catalogs.api.src.models.BaseCatalog;
import com.michaelcaxias.catalogs.api.src.models.Catalog;
import com.michaelcaxias.catalogs.api.src.models.CatalogItem;
import com.michaelcaxias.catalogs.api.src.models.Category;
import com.michaelcaxias.catalogs.api.src.models.Product;
import com.michaelcaxias.catalogs.api.src.repositories.CategoriesRepository;
import com.michaelcaxias.catalogs.api.src.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogsConsumerService implements ConsumerService<Integer> {
    @Autowired
    private CategoriesRepository categoriesRepo;

    @Autowired
    private ProductsRepository productsRepo;

    @Autowired
    private CatalogsConsumerMapper mapper;

    @Override
    public void process(final Integer ownerID) {
        final List<Category> categories = categoriesRepo.findByOwnerID(ownerID);

        final List<Catalog> catalogs = new ArrayList<>();

        categories.forEach(category -> {
            final List<Product> products = productsRepo.findByCategoryID(category.id());
            final List<CatalogItem> items = mapper.mapItem(products);
            final Catalog catalog = mapper.mapCatalog(category, items);
            catalogs.add(catalog);
        });

        final BaseCatalog fullCatalog = mapper.map(ownerID, catalogs);
    }
}
