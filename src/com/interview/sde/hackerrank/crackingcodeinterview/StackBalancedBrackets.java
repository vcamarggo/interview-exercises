package com.interview.sde.hackerrank.crackingcodeinterview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/balanced-brackets/problem
public class StackBalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> balanceHolder = new Stack<>();
        try {
            for (Character c : s.toCharArray()) {
                if (c == '{' || c == '[' || c == '(') {
                    balanceHolder.push(c);
                } else if (c == '}' && balanceHolder.pop() != '{') {
                    System.out.println(1);
                    return "NO";
                } else if (c == ']' && balanceHolder.pop() != '[') {
                    System.out.println(2);
                    return "NO";
                } else if (c == ')' && balanceHolder.pop() != '(') {
                    System.out.println(3);
                    return "NO";
                }
            }
        } catch (Exception e) {
            return "NO";
        }
        return balanceHolder.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
