package com.interview.sde.oop.shopping.tax;

import com.interview.sde.oop.shopping.product.Item;

public class NoTax  implements Tax{
    @Override
    public double applyTax(Item item) {
        return item.getPrice();
    }
    @Override
    public String toString() {
        return "NoTax{}";
    }
}
