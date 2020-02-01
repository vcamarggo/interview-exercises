package com.interview.sde.hackerrank.algorithm.implementation;
//https://www.hackerrank.com/challenges/circular-array-rotation/problem

import java.io.IOException;
import java.util.Scanner;

public class CircularArrayRotation {

    // Complete the rotLeft function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] rotated = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (0 <= i - k) {
                rotated[i] = a[i - k];
            } else {
                rotated[i] = a[(a.length + i - (k % a.length)) % a.length];
            }

        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = rotated[queries[i]];
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

        for (int value : result) {
            System.out.println(value);
        }
        scanner.close();
    }
}

