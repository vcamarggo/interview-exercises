package com.interview.sde.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;


//https://www.hackerrank.com/challenges/almost-sorted/problem
public class AlmostSorted {

    static void swap(int[] arr, int idxA, int idxB) {
        int temp = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = temp;
    }

    static void almostSorted(int[] arr) {
        int upReverseIndex = Integer.MAX_VALUE;
        int lowReverseIndex = Integer.MAX_VALUE;

        //try to find element for swapping
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i - 1] > arr[i] && arr[i + 1] > arr[i]) {
                if (upReverseIndex == Integer.MAX_VALUE) {
                    upReverseIndex = i;
                } else {
                    lowReverseIndex = i - 1;
                    break;
                }
            }
        }

        //if you find, test if this is a valid solution
        if (lowReverseIndex != Integer.MAX_VALUE) {
            swap(arr, lowReverseIndex, upReverseIndex);

            if (isSolution(arr)) {
                lowReverseIndex++;
                upReverseIndex++;
                System.out.println("yes");
                System.out.println("swap " + lowReverseIndex + " " + upReverseIndex);
                return;
            } else {
                swap(arr, lowReverseIndex, upReverseIndex);
            }
        }


        // if it not a valid solution, try to reverse and find a solution
        upReverseIndex = Integer.MAX_VALUE;
        lowReverseIndex = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                upReverseIndex = i;
                do {
                    i = i - 1;
                    lowReverseIndex = i;
                } while (i > 0 && arr[i - 1] > arr[i]);
                break;
            }
        }

        Arrays.sort(arr, lowReverseIndex, upReverseIndex + 1);

        if (isSolution(arr)) {
            System.out.println("yes");
            System.out.print(upReverseIndex - lowReverseIndex == 1 ? "swap " : "reverse ");
            System.out.print(lowReverseIndex + 1);
            System.out.print(" ");
            System.out.println(upReverseIndex + 1);
        } else {
            System.out.println("no");
        }
    }

    private static boolean isSolution(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}

