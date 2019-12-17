package com.interview.sde.hackerrank.crackingcodeinterview;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
public class RecursionFibonacciNumbers {

    static int[] memo = new int[31];

    public static int fibonacci(int n) {
        if (memo[n] == 0 && n != 0) {
            memo[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }
        return memo[n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        memo[0] = 0;
        memo[1] = 1;
        System.out.println(fibonacci(n));
    }
}
