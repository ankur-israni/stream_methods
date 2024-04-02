package com.core.newfeatures.java8.streams;

public class Item {

    private String name;
    private int quantity;
    private Double price;

    public Item(String name, int quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
