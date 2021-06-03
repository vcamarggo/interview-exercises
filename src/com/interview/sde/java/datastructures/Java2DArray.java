package com.interview.sde.java.datastructures;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-2d-array/problem
public class Java2DArray {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int count = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max = Math.max(count, max);
            }
        }
        System.out.println(max);
        scanner.close();
    }
}

