package com.interview.sde.java.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < queries; i++) {
            String[] input = scanner.nextLine().split(" ");
            System.out.println("Unordered " + Arrays.toString(input));
            System.out.println("Ascending " + Arrays.toString(bubbleSortAscending(Stream.of(input).map(Integer::parseInt).toArray(Integer[]::new))));
            System.out.println("Descending " + Arrays.toString(bubbleSortDescending(Stream.of(input).map(Integer::parseInt).toArray(Integer[]::new))));
            System.out.println();
        }
    }

    private static <T> T[] bubbleSort(T[] input, Comparator<T> comp) {
        for (int executions = 1; executions < input.length; executions++) {
            for (int j = 0; j < input.length - executions; j++) {
                if (comp.compare(input[j], input[j + 1]) > 0) {
                    T temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }

    private static Integer[] bubbleSortAscending(Integer[] input) {
        return bubbleSort(input, Comparator.naturalOrder());
    }

    private static Integer[] bubbleSortDescending(Integer[] input) {
        return bubbleSort(input, Comparator.reverseOrder());
    }
}
