package com.interview.sde.java.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/anagram/problem
public class Anagram {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the anagram function below.
    static int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);

        HashMap<Character, Integer> charInStringOccurrenceA = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            charInStringOccurrenceA.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int counter = s1.length();

        for (Character c : s2.toCharArray()) {
            if (charInStringOccurrenceA.containsKey(c)) {
                int occurrences = charInStringOccurrenceA.get(c);
                if (occurrences > 0) {
                    charInStringOccurrenceA.put(c, occurrences - 1);
                    counter -= 1;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
