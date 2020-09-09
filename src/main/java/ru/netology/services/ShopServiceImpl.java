package ru.netology.services;

import ru.netology.entity.Product;

// I - принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)
// класс реализует несколько отдельных интерфейсов (похожих на данном этапе по функциональности)

// Open-closed principle
// класс закрыт для изменения и открыт для расширения, благодаря тому,
// что принимает в конструкторе параметры типа Интерфейс,
// не зависящие от конкретной реализации

public class ShopServiceImpl implements CartService<Product>,CatalogService <Product>{
    private Storage catalog;
    private Storage cart;

    public ShopServiceImpl(Storage catalog, Storage cart) {
        this.catalog = catalog;
        this.cart = cart;
    }

    public void addToCart (Product product, int count) {
        cart.add(product, count);
        catalog.remove(product, count);
    }

    public void removeFromCart (Product product, int count) {
        cart.remove(product,count);
        catalog.add(product,count);
    }

    public void showCart() {
        cart.show();
    }

    public void addToCatalog(Product product, int count) {
        catalog.add(product,count);
    }

    public void removeFromCatalog(Product product, int count) {
        catalog.remove(product,count);
    }

    public void showCatalog() {
        catalog.show();
    }
}
