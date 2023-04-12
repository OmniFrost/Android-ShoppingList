package com.example.shoppinglist;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Item> cart;
    private static Storage instance;

    private Storage() {
        cart = new ArrayList<>();

    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addItem(Item item) {
        cart.add(item);
    }

    public ArrayList<Item> getItems() {
        return cart;
    }


}
