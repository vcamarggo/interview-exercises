package com.interview.sde.java.string;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/append-and-delete/problem
public class AppendAndDelete {
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        if (s.length() - t.length() > k) {
            return "No";
        } else {
            for (int i = 0; i < t.length() && i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (s.length() != t.length() && t.length() - i <= k) {
                        return "Yes";
                    } else {
                        return (t.length() - i) * 2 <= k ? "Yes" : "No";
                    }
                }
            }
            return (Math.abs(k - s.length() - t.length()) % 2 == 0 || k - t.length() > Math.abs(s.length() - t.length())) ? "Yes" : "No";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        System.out.println(result);
        scanner.close();
    }
}

