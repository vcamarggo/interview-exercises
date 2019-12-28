package com.interview.sde.hackerrank.algorithm.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/fibonacci-modified/problem
public class ModifiedFibonacci {
    // Complete the fibonacciModified function below.
    static String fibonacciModifiedIterative(long t1, long t2, int n) {
        BigInteger b1 = BigInteger.valueOf(t1);
        BigInteger b2 = BigInteger.valueOf(t2);
        BigInteger result = BigInteger.ZERO;
        for (int i = 2; i < n; i++) {
            result = b1.add(b2.pow(2));
            b1 = b2;
            b2 = result;
        }
        return result.toString();
    }

    static String fibonacciModifiedWithMemo(long t1, long t2, int n) {
        BigInteger[] memo = new BigInteger[n + 1];
        memo[0] = BigInteger.valueOf(t1);
        memo[1] = BigInteger.valueOf(t2);

        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 2].add(memo[i - 1].pow(2));
        }

        return memo[n - 1].toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int t1 = 0;

        int t2 = 1;

        int n = 10;

        String result = fibonacciModifiedWithMemo(t1, t2, n);
        System.out.println(result);
        scanner.close();
    }
}

