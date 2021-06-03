package com.interview.sde.crackingcodeinterview;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/candies/problem
public class DPCandies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long[] memo = new long[n];
        Arrays.fill(memo, 1);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                memo[i] = memo[i] + memo[i - 1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && memo[i] <= memo[i + 1]) {
                memo[i] = 1 + memo[i + 1];
            }
        }
        return java.util.stream.LongStream.of(memo).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);
        System.out.println(result);
        scanner.close();
    }
}
