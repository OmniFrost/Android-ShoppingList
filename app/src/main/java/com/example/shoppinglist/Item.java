package com.example.shoppinglist;

public class Item {

    private String name;
    private String description;
    private long time;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.time = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getTime() {
        return time;
    }

}
