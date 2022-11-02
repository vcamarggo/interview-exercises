package com.interview.sde.java.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < queries; i++) {
            String[] input = scanner.nextLine().split(" ");
            System.out.println("Unordered " + Arrays.toString(input));
            System.out.println("Ascending " + Arrays.toString(mergeSortAscending(Stream.of(input).mapToInt(Integer::parseInt).toArray())));
            System.out.println("Descending " + Arrays.toString(mergeSortDescending(Stream.of(input).mapToInt(Integer::parseInt).toArray())));
            System.out.println();
        }
    }


    private static int[] mergeSortAscending(int[] input) {
        return mergeSort(input, true);
    }

    private static int[] mergeSortDescending(int[] input) {
        return mergeSort(input, false);
    }

    private static int[] mergeSort(int[] input, boolean ascending) {
        int[] originalArray = Arrays.copyOfRange(input, 0, input.length);
        split(originalArray, 0, input.length, input, ascending);
        return input;
    }

    private static void split(int[] originalArray, int init, int end, int[] input, boolean ascending) {
        if (end - init > 1) {
            int middle = (end + init) / 2;
            split(input, init, middle, originalArray, ascending);
            split(input, middle, end, originalArray, ascending);
            merge(originalArray, init, middle, end, input, ascending);
        }
    }

    private static void merge(int[] originalArray, int init, int middle, int end, int[] input, boolean ascending) {
        int comparator = ascending ? 1 : -1;
        int i = init;
        int j = middle;
        for (int k = init; k < end; k++) {
            if (i < middle && (j >= end || Integer.compare(originalArray[j], originalArray[i]) == comparator)) {
                input[k] = originalArray[i];
                i = i + 1;
            } else {
                input[k] = originalArray[j];
                j = j + 1;
            }
        }
    }
}
