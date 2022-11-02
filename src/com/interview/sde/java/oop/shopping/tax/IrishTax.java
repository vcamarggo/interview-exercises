package com.interview.sde.java.oop.shopping.tax;

import com.interview.sde.java.oop.shopping.product.Item;

public class IrishTax implements Tax {
    private static final double IRISH_TAX_RATE = 0.23;

    @Override
    public double applyTax(Item item) {
        //Ideally, this applyTax would get a different tax depending on item type
        //it's left as static IRISH_TAX_RATE for simplicity's sake
        return item.getPrice() * (1 + IRISH_TAX_RATE);
    }

    @Override
    public String toString() {
        return "IrishTax{" + 100*IRISH_TAX_RATE + "%}";
    }
}
