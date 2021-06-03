package com.interview.sde.algorithm.strings;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/richie-rich/problem
public class HighestValuePalindrome {
    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        char[] inputChar = s.toCharArray();

        if (k > n) {
            return new String(new char[n]).replace("\0", "9");
        }

        boolean[] swapped = new boolean[n];
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            char iChar = inputChar[i];
            char jChar = inputChar[j];
            if (iChar != jChar) {
                if (k <= 0) {
                    return "-1";
                } else {
                    swapped[i] = true;
                    char overrideValue = (char) Math.max(iChar, jChar);
                    inputChar[i] = overrideValue;
                    inputChar[j] = overrideValue;
                    k--;
                }
            }
        }

        for (int i = 0, j = n - 1; i <= j && k > 0; i++, j--) {
            if (inputChar[i] != '9') {
                if (swapped[i] || i == j) {
                    inputChar[i] = '9';
                    inputChar[j] = '9';
                    k--;
                } else if (k > 1) {
                    inputChar[i] = '9';
                    inputChar[j] = '9';
                    k -= 2;
                }
            }
        }
        return String.valueOf(inputChar);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        System.out.println(result);
        scanner.close();
    }
}
