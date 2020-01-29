package com.interview.sde.hackerrank.algorithm.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/camelcase/problem
public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {
        char[] sArray = s.toCharArray();
        int counter = 1;
        for (int i = 1; i < sArray.length; i++) {
            if (sArray[i] > 64 && sArray[i] < 91) {
                counter++;
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

