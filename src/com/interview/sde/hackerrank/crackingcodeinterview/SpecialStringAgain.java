package com.interview.sde.hackerrank.crackingcodeinterview;

import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/special-palindrome-again/problem
//Not god at time complexity
public class SpecialStringAgain {
    static long isPalindrome(String str) {
        int k = 0;
        int j = str.length() - 1;
        char first = str.charAt(k);
        while (k < j) {
            if (str.charAt(k) != first) {
                return 3;
            }
            if (str.charAt(k) != str.charAt(j))
                return 0;
            k++;
            j--;
        }
        return 1;
    }

    static long substrCount(int n, String s) {
        long counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) {
                long result = isPalindrome(s.substring(i, j));
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

        long result = substrCount(n, s);
        System.out.println(result);
        scanner.close();
    }
}