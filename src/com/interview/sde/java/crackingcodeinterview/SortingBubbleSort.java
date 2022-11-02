package com.interview.sde.crackingcodeinterview;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
public class SortingBubbleSort {
    static void swap(int[] a, int j) {
        int temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j);
                    counter++;
                }
            }
        }
        System.out.println("Array is sorted in " + counter + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}

