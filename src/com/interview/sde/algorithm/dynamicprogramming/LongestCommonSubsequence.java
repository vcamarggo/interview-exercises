package com.interview.sde.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem
public class LongestCommonSubsequence {
    // Complete the longestCommonSubsequence function below.
    static List<Integer> longestCommonSubsequence(int[] a, int[] b) {
        int[][] dpMatrix = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j - 1] + 1;
                } else {
                    dpMatrix[i][j] = Math.max(dpMatrix[i - 1][j], dpMatrix[i][j - 1]);
                }
            }
        }

        return getResult(a, dpMatrix); // it's in the wrong order, I'm reversing while printing.
        // Change result.add(a[i - 1]); for result.add(0, a[i - 1]); to resolve without revert on printing
    }

    private static ArrayList<Integer> getResult(int[] a, int[][] dpMatrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = dpMatrix.length - 1;
        int j = dpMatrix[0].length - 1;
        while (dpMatrix[dpMatrix.length - 1][dpMatrix[0].length - 1] > result.size()) { //the last point in the matrix has the size of the result
            if (dpMatrix[i][j - 1] == dpMatrix[i - 1][j]) { // if they are equal, try to find in the diagonal point
                if (dpMatrix[i][j] > dpMatrix[i - 1][j - 1]) //only add to solution if it was matching character
                    result.add(a[i - 1]); // result.add(b[j - 1]); also works
                i--;
                j--;
            } else if (dpMatrix[i][j - 1] > dpMatrix[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }

        List<Integer> result = longestCommonSubsequence(a, b);

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));

            if (i != 0) {
                System.out.print(" ");
            }
        }


        scanner.close();
    }
}

