package com.interview.sde.java.datastructure;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/java-stack/problem
public class JavaStack {

    static String isBalanced(String s) {
        Stack<Character> balanceHolder = new Stack<>();
        try {
            for (Character c : s.toCharArray()) {
                if (c == '{' || c == '[' || c == '(') {
                    balanceHolder.push(c);
                } else if (c == '}' && balanceHolder.pop() != '{') {
                    return "false";
                } else if (c == ']' && balanceHolder.pop() != '[') {
                    return "false";
                } else if (c == ')' && balanceHolder.pop() != '(') {
                    return "false";
                }
            }
        } catch (Exception e) {
            return "false";
        }
        return balanceHolder.isEmpty() ? "true" : "false";
    }

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input));
        }

    }
}




