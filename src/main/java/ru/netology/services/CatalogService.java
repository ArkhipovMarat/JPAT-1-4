package ru.netology.services;

public interface CatalogService<T> {
    void addToCatalog(T t, int v);

    void removeFromCatalog(T t, int v);

    void showCatalog();
}
