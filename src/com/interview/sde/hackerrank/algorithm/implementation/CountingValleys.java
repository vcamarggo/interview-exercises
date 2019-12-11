package com.interview.sde.hackerrank.algorithm.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/counting-valleys/problem
public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int index = 0; index < n; index++) {

            if (stack.empty() || stack.peek().equals(s.charAt(index))) {
                stack.push(s.charAt(index));
            } else {
                if (stack.size() == 1 && stack.peek().equals('D')) {
                    result++;
                }
                stack.pop();
            }
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
