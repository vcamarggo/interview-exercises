package com.interview.sde.java.datastructure;

import java.util.ArrayList;
import java.util.List;

public class InvalidTransactions {

    public static final int NAME_FIELD = 0;
    public static final int TIME_FIELD = 1;
    public static final int MONEY_FIELD = 2;
    public static final int CITY_FIELD = 3;

    public List<String> invalidTransactions(String[] transactions) {

        List<String> invalidTransactions = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {
            String[] transaction = transactions[i].split(",");
            if (Integer.parseInt(transaction[MONEY_FIELD]) > 1000) {
                invalidTransactions.add(transactions[i]);
            } else {
                int k = 0;
                while (k < transactions.length) {
                    String[] kTransaction = transactions[k].split(",");
                    if (Math.abs(Integer.parseInt(transaction[TIME_FIELD]) - Integer.parseInt(kTransaction[TIME_FIELD])) <= 60
                            && k != i
                            && transaction[NAME_FIELD].equals(kTransaction[NAME_FIELD]) && !transaction[CITY_FIELD].equals(kTransaction[CITY_FIELD])) {
                        invalidTransactions.add(transactions[i]);
                        break;
                    }
                    k++;
                }
            }
        }
        return invalidTransactions;
    }

    public static void main(String[] args) {
        System.out.println(new InvalidTransactions().invalidTransactions(new String[]{"bob,689,1910,barcelona", "bob,832,1726,barcelona", "bob,820,596,bangkok", "bob,175,221,amsterdam"}));
        System.out.println(new InvalidTransactions().invalidTransactions(new String[]{"alex,676,260,bangkok", "bob,656,1366,bangkok", "alex,393,616,bangkok", "bob,820,990,amsterdam", "alex,596,1390,amsterdam"}));
        System.out.println(new InvalidTransactions().invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"}));
        System.out.println(new InvalidTransactions().invalidTransactions(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv", "alice,20,800,mtv", "alice,50,1200,mtv", "alice,20,800,mtv", "alice,50,100,beijing"}));
    }
}
