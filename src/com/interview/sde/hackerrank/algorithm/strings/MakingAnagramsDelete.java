package com.interview.sde.hackerrank.algorithm.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/making-anagrams/problem
public class MakingAnagramsDelete {

    // Complete the makingAnagrams function below.
    // This function counts number of deletion in both s1 and s2 to make them anagram of each other
    static int makingAnagrams(String s1, String s2) {
        HashMap<Character, Integer> charInStringOccurrenceA = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            charInStringOccurrenceA.put(c, charInStringOccurrenceA.getOrDefault(c, 0) + 1);
        }
        int counter = s1.length() + s2.length();

        for (Character c : s2.toCharArray()) {
            if (charInStringOccurrenceA.containsKey(c)) {
                int occurrences = charInStringOccurrenceA.get(c);
                if (occurrences > 0) {
                    charInStringOccurrenceA.put(c, occurrences - 1);
                    counter -= 2;
                }
            }
        }

        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


