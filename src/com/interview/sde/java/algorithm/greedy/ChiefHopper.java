package com.interview.sde.algorithm.greedy;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/chief-hopper/problem
public class ChiefHopper {
    // Complete the chiefHopper function below.
    static int chiefHopper(int[] heights) {
        int energy = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            energy = (int) Math.ceil((energy + heights[i]) / 2.0);
        }
        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = chiefHopper(arr);

        System.out.println(result);

        scanner.close();
    }
}

