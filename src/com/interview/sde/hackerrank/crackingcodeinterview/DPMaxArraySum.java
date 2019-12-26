package com.interview.sde.hackerrank.crackingcodeinterview;

import java.util.Scanner;

//https://www.hackerrank.com/interview/interview-preparation-kit/dynamic-programming
public class DPMaxArraySum {


    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] memo = new int[arr.length];

        if (arr.length == 0) return 0;
        memo[0] = Math.max(0, arr[0]);
        if (arr.length == 1) return arr[0];
        memo[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            memo[i] = Math.max(memo[i - 1], Math.max(arr[i], Math.max(arr[i] + memo[i - 2], memo[i - 2])));
        }

        return memo[arr.length - 1];
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

        int res = maxSubsetSum(arr);

        System.out.println(res);

        scanner.close();
    }
}

