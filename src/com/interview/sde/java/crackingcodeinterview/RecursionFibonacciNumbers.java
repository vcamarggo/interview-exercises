package com.interview.sde.java.crackingcodeinterview;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
public class RecursionFibonacciNumbers {

    static int[] memo = new int[31];

    public static int fibonacci3(int n) {
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static int fibonacci2(int n) {
        if (memo[n] == 0 && n != 0) {
            memo[n] = fibonacci2(n - 2) + fibonacci2(n - 1);
        }
        return memo[n];
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;

        int n2 = 0;
        int n1 = 1;
        int result;
        for (int i = 2; i <= n; i++) {
            result = n1 + n2;
            n2 = n1;
            n1 = result;
        }
        return n1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        memo[0] = 0;
        memo[1] = 1;
        System.out.println(fibonacci2(n));
    }
}

