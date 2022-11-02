package com.interview.sde.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < queries; i++) {
            String[] input = scanner.nextLine().split(" ");
            System.out.println("Unordered " + Arrays.toString(input));
            System.out.println("Ascending " + Arrays.toString(bubbleSortAscending(Stream.of(input).mapToInt(Integer::parseInt).toArray())));
            System.out.println("Descending " + Arrays.toString(bubbleSortDescending(Stream.of(input).mapToInt(Integer::parseInt).toArray())));
            System.out.println();
        }
    }

    private static int[] bubbleSort(int[] input, boolean ascending) {
        int comparator = ascending ? 1 : -1;
        for (int executions = 1; executions < input.length; executions++) {
            for (int j = 0; j < input.length - executions; j++) {
                if (Integer.compare(input[j], input[j + 1]) == comparator) {
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }

    private static int[] bubbleSortAscending(int[] input) {
        return bubbleSort(input, true);
    }

    private static int[] bubbleSortDescending(int[] input) {
        return bubbleSort(input, false);
    }
}
