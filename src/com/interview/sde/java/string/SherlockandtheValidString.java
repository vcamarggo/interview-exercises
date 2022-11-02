package com.interview.sde.java.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class SherlockandtheValidString {

    private static final Scanner scanner = new Scanner(System.in);

    static String isValid(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();

        char[] charsOfString = s.toCharArray();

        Arrays.sort(charsOfString);
        System.out.println(charsOfString);

        int value;
        for (Character c : charsOfString) {
            if (charMap.containsKey(c)) {
                value = charMap.get(c) + 1;
            } else {
                value = 1;
            }
            charMap.put(c, value);
        }

        HashMap<Integer, Integer> numberMap = new HashMap<>();

        for (Integer i : charMap.values()) {
            numberMap.merge(i, 1, Integer::sum);
        }


        if (numberMap.values().size() > 2) {
            return "NO";
        }
        if (numberMap.values().size() == 1) {
            return "YES";
        }

        Iterator<Integer> iter2 = numberMap.keySet().iterator();
        int freq1 = iter2.next();
        int freq2 = iter2.next();

        if (freq1 > freq2) {
            int temp = freq1;
            freq1 = freq2;
            freq2 = temp;
        }

        if (freq1 == 1) {
            return (numberMap.get(freq1) == 1 ? "YES" : "NO");
        }
        if (freq2 == freq1 + 1) {
            return (numberMap.get(freq2) == 1) ? "YES" : "NO";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

