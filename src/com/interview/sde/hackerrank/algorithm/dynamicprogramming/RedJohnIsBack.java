package com.interview.sde.hackerrank.algorithm.dynamicprogramming;

import java.util.Scanner;

public class RedJohnIsBack {

    static int[] memo = new int[41];
    static boolean[] prime = new boolean[1];

    // Complete the redJohn function below.
    static int calculateNumberOfWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = calculateNumberOfWays(n - 4) + calculateNumberOfWays(n - 1);
        return memo[n];
    }

    static int eratosthenesSieve(int n) {
        if (n > prime.length) {
            prime = new boolean[n + 1];
            for (int i = 0; i <= n; i++)
                prime[i] = true;

            for (int p = 2; p * p <= n; p++) {
                if (prime[p]) {
                    for (int i = p * 2; i <= n; i += p)
                        prime[i] = false;
                }
            }
        }
        int primeCounter = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primeCounter++;
        }
        return primeCounter;
    }

    static int redJohn(int n) {
        int numberOfWays = calculateNumberOfWays(n);
        if (numberOfWays <= 1) {
            return 0;
        }
        if (numberOfWays == 2) {
            return 1;
        }
        if (numberOfWays == 3) {
            return 2;
        }
        return eratosthenesSieve(numberOfWays);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;


        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = redJohn(n);

            System.out.println(result);
        }

        scanner.close();
    }

}
