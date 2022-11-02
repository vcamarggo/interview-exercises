package com.interview.sde.java.crackingcodeinterview;

import java.util.Scanner;

//https://www.hackerrank.com/interview/interview-preparation-kit/sorting
public class SortingMergeSortCounter {
    static long merge(int[] arr, int l, int m, int r) {
        long counterInversion = 0;
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        System.arraycopy(arr, l, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
                counterInversion += (m - l + 1 - i);
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return counterInversion;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static long sort(int[] arr, int l, int r) {
        long sumInversions = 0;
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sumInversions += sort(arr, l, m);
            sumInversions += sort(arr, m + 1, r);

            // Merge the sorted halves
            sumInversions += merge(arr, l, m, r);
        }
        return sumInversions;
    }

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.println(result);
        }


        scanner.close();
    }
}
