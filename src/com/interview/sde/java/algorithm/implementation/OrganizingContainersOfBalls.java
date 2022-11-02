package com.interview.sde.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
public class OrganizingContainersOfBalls {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int[] rowResults = new int[container.length];
        int[] columnResults = new int[container.length];

        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container[0].length; j++) {
                rowResults[i] += container[i][j];
                columnResults[j] += container[i][j];
            }
        }

        Arrays.sort(columnResults);
        Arrays.sort(rowResults);

        return Arrays.equals(columnResults, rowResults) ? "Possible" : "Impossible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);
            System.out.println(result);
        }


        scanner.close();
    }
}
