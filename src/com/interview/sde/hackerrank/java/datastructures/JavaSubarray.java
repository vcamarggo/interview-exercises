package com.interview.sde.hackerrank.java.datastructures;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-negative-subarray/problem
public class JavaSubarray {

    static int isSumNegative(int[] a, int i, int j) {
        int sum = 0;
        for (; j <= i; j++) {
            sum += a[j];
        }
        return sum < 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];

        int counter = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            for (int j = i; j >= 0; j--) {
                counter += isSumNegative(a, i, j);
            }
        }
        System.out.println(counter);
    }
}


