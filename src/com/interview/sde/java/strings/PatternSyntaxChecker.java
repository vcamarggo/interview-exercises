package com.interview.sde.java.strings;

import java.util.Scanner;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
public class PatternSyntaxChecker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            testCases--;
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }

        }
    }

}
