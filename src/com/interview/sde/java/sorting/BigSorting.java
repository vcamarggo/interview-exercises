package com.interview.sde.java.sorting;

import java.io.*;
import java.util.Arrays;

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

        Arrays.sort(unsorted, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() > o2.length() ? 1 : -1;
            }
        });

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
