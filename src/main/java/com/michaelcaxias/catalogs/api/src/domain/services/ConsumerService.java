package com.michaelcaxias.catalogs.api.src.domain.services;

public interface ConsumerService<T> {
    void process(T message);
}
