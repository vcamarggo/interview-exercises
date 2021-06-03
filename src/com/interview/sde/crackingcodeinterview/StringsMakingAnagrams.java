package com.interview.sde.crackingcodeinterview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class StringsMakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> charInStringOccurrenceA = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            Character charAtI = a.charAt(i);
            charInStringOccurrenceA.put(charAtI, charInStringOccurrenceA.getOrDefault(charAtI, 0) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            Character charAtI = b.charAt(i);
            charInStringOccurrenceA.put(charAtI, charInStringOccurrenceA.getOrDefault(charAtI, 0) - 1);
        }

        int sum = 0;
        for (Integer occurrence : charInStringOccurrenceA.values()) {
            sum += Math.abs(occurrence);
        }


        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
