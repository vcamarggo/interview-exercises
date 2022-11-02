package com.interview.sde.java.array;

import java.util.Arrays;

//https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomer {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(money -> Arrays.stream(money).sum()).max(Integer::compareTo).get();
    }
}
