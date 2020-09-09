package ru.netology.services;

public interface Storage<T> {
    void add(T t, int v);
    void show();
    void remove(T t, int v);
}
