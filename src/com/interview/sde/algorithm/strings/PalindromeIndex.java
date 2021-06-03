package com.interview.sde.algorithm.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/palindrome-index/problem
public class PalindromeIndex {
    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        int palindromeIndex = -1;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (isPalindrome(s, i)) {
                    return i;
                }
                if (isPalindrome(s, j)) {
                    return j;
                }
            }
        }
        return -1;
    }

    static boolean isPalindrome(String s, int index) {
        for (int i = index + 1, j = s.length() - 1 - index; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
