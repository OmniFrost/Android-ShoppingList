package com.example.shoppinglist;

public class Item {

    private String name;
    private String description;
    private long time;
    private boolean superImportant;

    public Item(String name, String description, boolean superImportant) {
        this.name = name;
        this.description = description;
        this.time = System.currentTimeMillis();
        this.superImportant = superImportant;
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


    public boolean checkIfSuperImportant() {
        return superImportant;
    }

}
