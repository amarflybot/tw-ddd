package com.thoughtworks.ddd_workshop.domain;

import java.util.Objects;

public class Item {

    private final Product product;
    private Integer quantity;

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Item(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(product, item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
