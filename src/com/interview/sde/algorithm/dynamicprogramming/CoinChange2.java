package com.interview.sde.algorithm.dynamicprogramming;

//https://leetcode.com/problems/coin-change-2
public class CoinChange2 {

    public static int change(int amount, int[] coins) {
        int[][] solution = new int[coins.length+1][amount+1];

        solution[0][0] = 1;

        for (int row = 1 ; row < solution.length ; row++){

            int coin = coins[row-1];

            for (int column = 0 ; column < solution[0].length ; column++){
                if(column - coin >= 0){
                    solution[row][column] += solution[row][column-coin];
                }
                solution[row][column] += solution[row-1][column];
            }
        }

        return solution[coins.length][amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{ 1,2,5}));
    }
}

