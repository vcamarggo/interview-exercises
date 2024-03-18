package com.interview.sde.java.oop.shopping.tax;

import com.interview.sde.java.oop.shopping.product.Item;

public class NoTax implements Tax {
    @Override
    public double applyTax(Item item) {
        return item.getPrice();
    }

    @Override
    public String toString() {
        return "NoTax{}";
    }
}
