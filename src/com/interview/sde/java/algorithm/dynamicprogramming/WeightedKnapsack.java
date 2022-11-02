package com.interview.sde.algorithm.dynamicprogramming;

//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/
public class WeightedKnapsack {
    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] maxWeight = new int[n + 1][W + 1];
        for (int row = 1; row < maxWeight.length; row++) {
            for (int column = 1; column < maxWeight[0].length; column++) {
                maxWeight[row][column] =
                        //If I could fit the current item (wt[row-1]) in a bag
                        wt[row - 1] <= column
                                //Get max of not adding current item or adding it + the previous pick capacity should I had picked the current item
                                ? Math.max(maxWeight[row - 1][column], val[row - 1] + maxWeight[row - 1][column - wt[row - 1]])
                                //Cannot add the item
                                : maxWeight[row - 1][column];
            }
        }
        return maxWeight[maxWeight.length - 1][maxWeight[0].length - 1];
    }

}
