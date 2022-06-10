package com.interview.sde.algorithm.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/strong-password/problem
public class StrongPassword {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the minimumNumber function below.
    static int minimumNumber(String password) {
        int counterMissingGroup = 0;

        if (!password.matches(".*[A-Z]+.*")) {
            counterMissingGroup++;
        }
        if (!password.matches(".*[a-z]+.*")) {
            counterMissingGroup++;
        }
        if (!password.matches(".*[0-9]+.*")) {
            counterMissingGroup++;
        }
        if (!password.matches(".*[-!@#$%^&*()+]+.*")) {
            counterMissingGroup++;
        }

        return Math.max(counterMissingGroup, 6 - password.length());
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
