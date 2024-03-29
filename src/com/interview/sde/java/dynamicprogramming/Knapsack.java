package com.interview.sde.java.dynamicprogramming;

import java.util.Scanner;
import java.util.stream.IntStream;

//https://www.hackerrank.com/challenges/unbounded-knapsack/problem
public class Knapsack {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the unboundedKnapsack function below.
    static int unboundedKnapsack(int targetWeight, int[] arr) {
        arr = IntStream.of(arr).distinct().toArray();
        int[][] resultMatrix = new int[arr.length + 1][targetWeight + 1];
        for (int i = 0; i < targetWeight + 1; i++) {
            resultMatrix[0][i] = i;
        }

        for (int row = 1; row < resultMatrix.length; row++) {
            for (int column = 1; column < resultMatrix[0].length; column++) {
                int objectWeight = arr[row - 1];
                //If the object is heavier than the max weight I can carry
                if (objectWeight > column) {
                    resultMatrix[row][column] = resultMatrix[row - 1][column];
                } else {
                    //This is choosing between keeping the previous minimum remaining amount or using the current value to reach to a smaller amount
                    resultMatrix[row][column] = Math.min(resultMatrix[row - 1][column], resultMatrix[row][column - objectWeight]);
                }
            }
        }

        return targetWeight - resultMatrix[resultMatrix.length - 1][resultMatrix[0].length - 1];
    }

    public static void main(String[] args) {

        int t = scanner.nextInt();
        for (int x = 0; x < t; x++) {
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = unboundedKnapsack(k, arr);
            System.out.println(result);
        }
        scanner.close();
    }
}
