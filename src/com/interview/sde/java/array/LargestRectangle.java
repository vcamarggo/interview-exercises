package com.interview.sde.java.array;

import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/three-month-preparation-kit-largest-rectangle/problem
public class LargestRectangle {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        long result = 0;
        for (int i = 0; i < h.length; i++) {
            int countRight = 0;
            for (int j = i + 1; j < h.length && h[j] >= h[i]; j++) {
                countRight++;
            }
            int countLeft = 0;
            for (int k = i - 1; k >= 0 && h[k] >= h[i]; k--) {
                countLeft++;
            }
            result = Math.max(result, (1 + countLeft + countRight) * h[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        System.out.println(result);

        scanner.close();
    }
}

