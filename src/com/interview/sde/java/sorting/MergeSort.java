package com.interview.sde.java.sorting;

import java.util.Arrays;
import java.util.Comparator;
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
        return mergeSort(input, Comparator.naturalOrder());
    }

    private static int[] mergeSortDescending(int[] input) {
        return mergeSort(input, Comparator.reverseOrder());
    }

    private static int[] mergeSort(int[] input, Comparator<Integer> comparator) {
        int[] originalArray = Arrays.copyOfRange(input, 0, input.length);
        split(originalArray, 0, input.length, input, comparator);
        return input;
    }

    private static void split(int[] originalArray, int init, int end, int[] input, Comparator<Integer> comparator) {
        if (end - init > 1) {
            int middle = (end + init) / 2;
            split(input, init, middle, originalArray, comparator);
            split(input, middle, end, originalArray, comparator);
            merge(originalArray, init, middle, end, input, comparator);
        }
    }

    private static void merge(int[] originalArray, int init, int middle, int end, int[] input, Comparator<Integer> comparator) {
        int i = init;
        int j = middle;
        for (int k = init; k < end; k++) {
            if (i < middle && (j >= end || comparator.compare(originalArray[j], originalArray[i]) > 0)) {
                input[k] = originalArray[i];
                i = i + 1;
            } else {
                input[k] = originalArray[j];
                j = j + 1;
            }
        }
    }
}
