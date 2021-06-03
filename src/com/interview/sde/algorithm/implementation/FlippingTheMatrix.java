package com.interview.sde.algorithm.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/flipping-the-matrix/problem
public class FlippingTheMatrix {

    static int flippingMatrix(int[][] matrix) {
        int sum = 0;
        for (int row1 = 0; row1 < matrix.length / 2; row1++) {
            for (int column1 = 0; column1 < matrix.length / 2; column1++) {
                int row2 = matrix.length - 1 - row1;
                int column2 = matrix.length - 1 - column1;
                sum += Math.max(Math.max(matrix[row1][column1], matrix[row1][column2]), Math.max(matrix[row2][column1], matrix[row2][column2]));
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] matrix = new int[2*n][2*n];

            for (int i = 0; i < 2*n; i++) {
                String[] matrixRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2*n; j++) {
                    int matrixItem = Integer.parseInt(matrixRowItems[j]);
                    matrix[i][j] = matrixItem;
                }
            }

            int result = flippingMatrix(matrix);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
