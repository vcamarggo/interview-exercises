package com.interview.sde.java.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < queries; i++) {
            String[] input = scanner.nextLine().split(" ");
            System.out.println("Unordered " + Arrays.toString(input));
            System.out.println("Ascending " + Arrays.toString(quickSortAscending(Stream.of(input).mapToInt(Integer::parseInt).toArray())));
            System.out.println("Descending " + Arrays.toString(quickSortDescending(Stream.of(input).mapToInt(Integer::parseInt).toArray())));
            System.out.println();
        }
    }


    private static int[] quickSortAscending(int[] input) {
        return quickSortInitializer(input, Comparator.naturalOrder());
    }

    private static int[] quickSortDescending(int[] input) {
        return quickSortInitializer(input, Comparator.reverseOrder());
    }

    private static int[] quickSortInitializer(int[] input, Comparator<Integer> comparator) {
        return quickSort(input, comparator, 0, input.length - 1);
    }

    private static int[] quickSort(int[] input, Comparator<Integer> comparator, int low, int high) {
        if (low < high) {
            int partitionPoint = partition(input, comparator, low, high);
            quickSort(input, comparator, low, partitionPoint - 1);
            quickSort(input, comparator, partitionPoint + 1, high);
        }
        return input;
    }

    private static int partition(int[] input, Comparator<Integer> comparator, int low, int high) {

        int pivot = input[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (comparator.compare(pivot, input[j]) > 0) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
            }
        }
        int temp = input[i];
        input[i] = input[high];
        input[high] = temp;
        return i;
    }

}
