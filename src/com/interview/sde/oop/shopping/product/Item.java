package com.interview.sde.oop.shopping.product;

public class Item {
    private final long id;
    private final double price;
    private final String name;

    public Item(long id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
