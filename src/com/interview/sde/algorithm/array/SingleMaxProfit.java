package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class SingleMaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            min = Math.min(price, min);
            max = Math.max(max, price - min);
        }

        return max;
    }
}
