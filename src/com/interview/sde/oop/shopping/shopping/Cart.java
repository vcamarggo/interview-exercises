package com.interview.sde.oop.shopping.shopping;

import com.interview.sde.oop.shopping.tax.NoTax;
import com.interview.sde.oop.shopping.tax.Tax;

import java.util.List;

public class Cart {
    private final String shoppingList;

    private final String taxClass;

    private final String total;

    public Cart(List<BuyingItem> shoppingList, Tax taxClass) {
        StringBuilder shoppingListBuilder = new StringBuilder("\n");
        this.taxClass = taxClass.toString();

        double total = 0;
        for (BuyingItem buyingItem : shoppingList) {
            buyingItem.applyTax(taxClass);
            total += buyingItem.getTotalItemPrice();
            shoppingListBuilder.append(buyingItem).append("\n");
        }

        this.shoppingList = shoppingListBuilder.toString();

        this.total = String.valueOf(total);
    }

    public Cart(List<BuyingItem> shoppingList) {
        this(shoppingList, new NoTax());
    }

    public String getCheckoutAsString() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "shoppingList='" + shoppingList + '\'' +
                ", taxClass='" + taxClass + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
