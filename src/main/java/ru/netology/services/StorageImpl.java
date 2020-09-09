package ru.netology.services;

import ru.netology.entity.Product;
import ru.netology.entity.TypeOfProduct;

import java.util.*;

// принцип Single Responsibility Principle
// Класс выпоняет только те функции (описанные в интерфейсе), для которого он предназначен:
// хранение, добавление/удаление элементов, просмотр элементов

// L - принцип замены Барбары Лисков
// Базовый класс для Корзины и Каталога магазина. Наследник может выполнять базовые функции подителя -
// хранение, добавление/удаление элементов, просмотр элементов

public class StorageImpl implements Storage<Product> {
    private String title;
//    значение параметра title не используется в коде напрямую, а задается через конструктор класса,
//    и придает ему гибкость в использовании (класс используется для как корзина и как каталог)

    Map<TypeOfProduct, Map<Product, Integer>> productCatalog;
    Map<Product, Integer> products;

    public StorageImpl(String title) {
        this.title = title;
        productCatalog = new TreeMap<>();
        products = new TreeMap<>(Comparator.comparing(Product::getName));
    }

    private static void print(Map.Entry<Product, Integer> value) {
        System.out.print(value.getKey());
        System.out.println("  количество:" + value.getValue());
    }

    @Override
    public void add(Product product, int count) {
        TypeOfProduct typeOfProduct = product.getType();
        if (productCatalog.containsKey(typeOfProduct)) {
            products = productCatalog.get(typeOfProduct);
            products.put(product, count);
            productCatalog.put(typeOfProduct, products);
        } else {
            products = new TreeMap<>(Comparator.comparing(Product::getName));
            products.put(product, count);
            productCatalog.put(typeOfProduct, products);
        }
    }

    @Override
    public void show() {
        System.out.println(title);
        System.out.println("-------------------------------------");
        for (Map.Entry entry : productCatalog.entrySet()) {
            System.out.println("В разделе для '" + entry.getKey() + "' имеются следующие товары: ");
            productCatalog.get(entry.getKey()).entrySet().forEach(StorageImpl::print);
        }
        System.out.println("-------------------------------------");
        System.out.println("");
    }

    @Override
    public void remove(Product product, int count) {
        Map<Product, Integer> map = productCatalog.get(product.getType());

        for (Iterator<Map.Entry<Product, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Product, Integer> entry = it.next();

            if (entry.getKey().equals(product)) {
                int count2 = (int) entry.getValue() - count;
                    if (count2==0) {
                        it.remove();
                        break;
                    }
                entry.setValue(count2);
            }
        }
    }
}