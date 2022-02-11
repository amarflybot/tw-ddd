package com.thoughtworks.ddd_workshop.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CartTest {

    @Test
    public void shouldAddAnIpadProToTheCart() {
        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("Ipad Pro"), 1));
        List<Item> allItems = cart.getAllItems();
        Assertions.assertEquals(1, allItems.size());
        Assertions.assertEquals(new Item(new Product("Ipad Pro"), 1), allItems.get(0));
    }

    @Test
    public void shouldAddAnHeroInkPenToTheCart() {

        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("Hero Ink Pen"), 1));
        List<Item> allItems = cart.getAllItems();
        Assertions.assertEquals(1, allItems.size());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(new Product("Hero Ink Pen"), 1));
        Assertions.assertEquals(expected, allItems);
    }

    @Test
    public void shouldAddTwoGMCricketBatToTheCart() {

        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("GM Cricket Bat"), 2));
        Assertions.assertEquals(1, cart.getTotalItemCount());
    }

    @Test
    public void shouldRemoveAnIpadProToTheCart() {
        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("Ipad Pro"), 1));
        cart.addItems(new Item(new Product("GM Cricket Bat"), 1));
        Assertions.assertEquals(2, cart.getTotalItemCount());
        cart.removeItem(new Item(new Product("Ipad Pro")));
        Assertions.assertEquals(1, cart.getTotalItemCount());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(new Product("GM Cricket Bat"), 1));
        Assertions.assertEquals(expected, cart.getAllItems());
    }

    @Test
    public void shouldFindListOfRemovedProductName() {
        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("Ipad Pro"), 1));
        cart.addItems(new Item(new Product("GM Cricket Bat"), 1));
        cart.removeItem(new Item(new Product("Ipad Pro")));
        List<Item> removedItems = cart.getRemovedItems();
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(new Product("Ipad Pro")));
        Assertions.assertEquals(expected, removedItems);
        Assertions.assertEquals(List.of("Ipad Pro"), removedItems.stream().map(item -> item.getProduct().getName()).collect(Collectors.toList()));
    }

    @Test
    public void shouldReturnFalseForTwoCartsWithSameItems() {
        Cart cart1 = new Cart("cartId1");
        Cart cart2 = new Cart("cartId2");
        Item item1 = new Item(new Product("Ipad"), 1);
        Item item2 = new  Item(new Product("Ipad"), 1);
        cart1.addItems(item1);
        cart2.addItems(item2);
        Assertions.assertFalse(cart1.equals(cart2));
    }

}
