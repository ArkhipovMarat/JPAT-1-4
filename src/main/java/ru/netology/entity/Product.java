package ru.netology.entity;

import java.util.Objects;

// принцип Single Responsibility Principle
// Класс выпоняет только те функции, для которого он предназначен:
// храненилище параметров

public class Product {
    private TypeOfProduct type;
    private String name;
    private String description;
    private int price; // для упрощения тип int

    public Product(TypeOfProduct type, String name, String description, int price) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public TypeOfProduct getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "  название:" + name +
                "  описание:" + description +
                "  цена:" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                type == product.type &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, description, price);
    }
}
