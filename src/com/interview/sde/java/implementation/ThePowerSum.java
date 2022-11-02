package com.interview.sde.java.implementation;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/the-power-sum/problem
public class ThePowerSum {
    static int powerSum(int X, int N) {
        int nthRoot = (int) Math.round(Math.pow(X, 1.0 / N));
        return powerSum(X, N, nthRoot, 1);
    }

    // Complete the powerSum function below.
    static int powerSum(double X, int N, int nthRoot, int index) {
        if (X < 0) {
            return 0;
        }
        if (X == 0) {
            return 1;
        }
        int counter = 0;
        for (int i = index; i <= nthRoot; i++) {
            counter += powerSum(X - Math.pow(i, N), N, nthRoot, i + 1);
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        System.out.println(result);
        scanner.close();
    }


}
