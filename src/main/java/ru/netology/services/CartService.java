package ru.netology.services;

public interface CartService<T> {
    void addToCart(T t, int v);

    void removeFromCart(T t, int v);

    void showCart();
}
