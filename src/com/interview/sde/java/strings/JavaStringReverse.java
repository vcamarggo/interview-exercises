package com.interview.sde.java.strings;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-string-reverse/problem
public class JavaStringReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        boolean isPalindrome = true;
        for (int i = 0, j = A.length() - 1; i < j; i++, j--) {
            if (A.charAt(i) != A.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome ? "Yes" : "No");
    }
}



