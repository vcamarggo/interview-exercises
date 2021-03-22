package com.interview.sde.hackerrank.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

//https://leetcode.com/problems/coin-change/
public class CoinChangeMinimumCoins {

    public static int coinChange(Integer[] coins, int amount) {
        int[] solution = new int[amount+1];

        Arrays.fill(solution, Integer.MAX_VALUE);
        solution[0] = 0;

        for(Integer coin : coins){
            for(int i = 1 ; i <= amount ; i++){
                if(i-coin >= 0 && solution[i-coin]+1 != Integer.MIN_VALUE){
                    solution[i] = Math.min(solution[i-coin]+1 , solution[i]);
                }
            }
        }
        return solution[amount] == Integer.MAX_VALUE ? -1 : solution[amount];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        Integer[] coins = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .sorted().toArray(Integer[]::new);

        // Print the fewest number of coins that you need to make up 'n' units using 'c' coins

        long ways = coinChange(coins, n);
        System.out.println(ways);

        bufferedReader.close();
    }
}

