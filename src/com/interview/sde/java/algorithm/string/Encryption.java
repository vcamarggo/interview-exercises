package com.interview.sde.algorithm.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/encryption/problem
public class Encryption {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll(" ", "");
        double sqrt = Math.sqrt(s.length());
        int rows = (int) Math.floor(sqrt);
        int cols = (int) Math.ceil(sqrt);

        if (rows * cols < s.length()) {
            rows++;
        }

        System.out.print(cols);

        String[][] encrypted = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                encrypted[i][j] = j + i * cols < s.length()
                        ? String.valueOf(s.charAt(j + i * cols))
                        : "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                sb.append(encrypted[i][j]);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
