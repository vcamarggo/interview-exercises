package com.interview.sde.crackingcodeinterview;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/special-palindrome-again/problem
public class SpecialStringAgain {
    static long isPalindrome(char[] str, int init, int end) {
        int k = init;
        int j = end - 1;
        char first = str[k];
        while (k < j) {
            if (str[k] != first) {
                return 3;
            }
            if (str[k] != str[j])
                return 0;
            k++;
            j--;
        }
        return 1;
    }

    static long substrCount(int n, String s) {
        long counter = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) {
                long result = isPalindrome(sChars, i, j);
                if (result == 3) {
                    break;
                } else {
                    counter += result;
                }
            }
        }
        return counter + s.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(5, "asasd");
        System.out.println(result);
        scanner.close();
    }
}
