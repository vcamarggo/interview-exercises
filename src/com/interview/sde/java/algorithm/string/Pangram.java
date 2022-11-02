package com.interview.sde.algorithm.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/pangrams/problem
public class Pangram {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the pangrams function below.
    static String pangrams(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (Character letter : s.toCharArray()) {
            uniqueChars.add(Character.toLowerCase(letter));
        }
        return uniqueChars.size() == 27 ? "pangram" : "not pangram";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

