package com.interview.sde.crackingcodeinterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
public class HashTableIceCreamParlor {

    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> costPosition = new HashMap<>();
        for (int i = 1; i <= cost.length; i++) {
            costPosition.put(i, cost[i - 1]);
        }
        Arrays.sort(cost);
        int i = -1;
        int j;
        do {
            i++;
            j = Arrays.binarySearch(cost, money - cost[i]);
        } while (i < cost.length - 1 && j < 0 || (j >= 0 && cost[i] + cost[j] != money));

        int[] twoElements = new int[2];
        for (Map.Entry<Integer, Integer> entry : costPosition.entrySet()) {
            if (entry.getValue() == cost[i] && twoElements[0] == 0) {
                twoElements[0] = entry.getKey();
            }
            if (entry.getValue() == cost[j] && twoElements[0] != entry.getKey()) {
                twoElements[1] = entry.getKey();
            }
        }
        System.out.println(twoElements[0] + " " + twoElements[1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
