package com.interview.sde.algorithm.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/repeated-string/problem
public class RepeatedString {


    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long countA = (s.split("a", -1).length) - 1;
        long rest = (n % s.length());
        long repeat = (n / s.length());
        long count = 0;
        for (int i = 0; i < rest; i++)
            if (s.charAt(i) == 'a')
                count++;
        return (countA * repeat) + count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

