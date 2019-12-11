package com.interview.sde.hackerrank.crackingcodeinterview;

import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class HashTablesRansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineWordsCounter = new HashMap<>();
        for (String s : magazine) {
            magazineWordsCounter.put(s, magazineWordsCounter.getOrDefault(s, 0) + 1);
        }

        for (String s : note) {
            if (!magazineWordsCounter.containsKey(s) || magazineWordsCounter.get(s) < 1) {
                System.out.println("No");
                return;
            } else {
                magazineWordsCounter.put(s, magazineWordsCounter.get(s) - 1);
            }
        }
        System.out.println("Yes");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.arraycopy(magazineItems, 0, magazine, 0, m);

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.arraycopy(noteItems, 0, note, 0, n);

        checkMagazine(magazine, note);

        scanner.close();
    }
}

