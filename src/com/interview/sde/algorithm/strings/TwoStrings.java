package com.interview.sde.algorithm.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Set<String> uniqueCharacterOfString1 = new HashSet<>(Arrays.asList(s1.split("")));
        for (int i = 0; i < s2.length(); i++) {
            if (uniqueCharacterOfString1.contains(Character.toString(s2.charAt(i)))) {
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

