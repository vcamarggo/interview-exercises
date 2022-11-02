package com.interview.sde.java.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/closest-numbers/problem
public class ClosestNumbers {

    static int[] closestNumbers(int[] arr) {
        List<Integer> pairs = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (pairs.isEmpty() || pairs.get(1) - pairs.get(0) == arr[i + 1] - arr[i]) {
                pairs.add(arr[i]);
                pairs.add(arr[i + 1]);
            } else if (pairs.get(1) - pairs.get(0) > arr[i + 1] - arr[i]) {
                pairs.clear();
                pairs.add(arr[i]);
                pairs.add(arr[i + 1]);
            }
        }
        return pairs.stream().mapToInt(i -> i).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
