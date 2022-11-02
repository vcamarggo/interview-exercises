package com.interview.sde.algorithm.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/the-time-in-words/problem
public class TheTimeInWords {
    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        List<String> numbers = Arrays.asList("o' clock", "one minute", "two minutes", "three minutes", "four minutes", "five minutes", "six minutes", "seven minutes", "eight minutes", "nine minutes", "ten minutes",
                "eleven minutes", "twelve minutes", "thirteen minutes", "fourteen minutes", "quarter", "sixteen minutes", "seventeen minutes", "eighteen minutes", "nineteen minutes", "twenty minutes", "twenty one minutes",
                "twenty two minutes", "twenty three minutes", "twenty four minutes", "twenty five minutes", "twenty six minutes", "twenty seven minutes", "twenty eight minutes", "twenty nine minutes", "half");
        List<String> hours = Arrays.asList("o' clock",
                "one", "two", "three", "four",
                "five", "six", "seven",
                "eight", "nine", "ten",
                "eleven", "twelve");

        if (m > 30) {
            return numbers.get(60 - m) + " to " + hours.get(h + 1);
        } else if (m == 0) {
            return hours.get(h) + " " + numbers.get(m);
        } else {
            return numbers.get(m) + " past " + hours.get(h);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
