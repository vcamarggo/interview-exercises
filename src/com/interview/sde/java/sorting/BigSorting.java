package com.interview.sde.java.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

//https://www.hackerrank.com/challenges/big-sorting/problem
public class BigSorting {

    private static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(scanner.readLine());

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            unsorted[i] = scanner.readLine();
        }

        Arrays.sort(unsorted, Comparator.comparing(String::length).thenComparing(String::compareTo));

        for (int i = 0; i < unsorted.length; i++) {
            bufferedWriter.write(unsorted[i]);

            if (i != unsorted.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
