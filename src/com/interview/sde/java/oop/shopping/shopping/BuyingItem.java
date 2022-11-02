package com.interview.sde.oop.shopping.shopping;

import com.interview.sde.oop.shopping.product.Item;
import com.interview.sde.oop.shopping.tax.Tax;

public class BuyingItem {
    private final Item item;
    private final int quantity;
    private double total;

    public BuyingItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.total = item.getPrice() * quantity;
    }

    public void applyTax(Tax taxClass) {
        total = taxClass.applyTax(item) * quantity;
    }

    public double getTotalItemPrice() {
        return total;
    }

    @Override
    public String toString() {
        return "BuyingItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
