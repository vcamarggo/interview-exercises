package com.interview.sde.java.oop.shopping;

import com.interview.sde.java.oop.shopping.product.Item;
import com.interview.sde.java.oop.shopping.shopping.BuyingItem;
import com.interview.sde.java.oop.shopping.shopping.Cart;
import com.interview.sde.java.oop.shopping.tax.IrishTax;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<BuyingItem> shoppingList = List.of(new BuyingItem(new Item(1, 1.5, "Chocolate"), 3),
                new BuyingItem(new Item(2, 2, "Juice"), 1));
        Cart cart = new Cart(shoppingList, new IrishTax());
        new Runner().checkout(cart);
    }

    public void checkout(Cart cart) {
        System.out.println(cart.getCheckoutAsString());
    }
}
