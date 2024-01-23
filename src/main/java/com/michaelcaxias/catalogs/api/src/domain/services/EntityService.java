package com.michaelcaxias.catalogs.api.src.domain.services;

import java.util.List;

public interface EntityService<E, D> {
    E findByID(String id);
    List<E> findAll();
    E save(D dto);
    E updateByID(String id, D dto);
}
