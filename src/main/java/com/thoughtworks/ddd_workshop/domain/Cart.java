package com.thoughtworks.ddd_workshop.domain;

import java.util.*;

public class Cart {

    private final List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    public Integer getTotalItemCount() {
        return this.items.size();
    }

    public List<Item> getAllItems() {
        return this.items;
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
