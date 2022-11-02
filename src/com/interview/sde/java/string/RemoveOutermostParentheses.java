package com.interview.sde.java.string;

import java.util.Stack;

//https://leetcode.com/problems/remove-outermost-parentheses/
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String S) {
        Stack<Character> parenthesis = new Stack<>();

        int startParenthesis = 0;

        //This variable counts the skew from the number of parenthesis removed
        int removed = 0;

        StringBuilder builder = new StringBuilder(S);

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (parenthesis.isEmpty()) {
                    startParenthesis = i;
                }
                parenthesis.push('(');
            } else if (S.charAt(i) == ')') {
                if (parenthesis.size() == 1) {
                    builder.deleteCharAt(startParenthesis - removed);
                    removed++;
                    builder.deleteCharAt(i - removed);
                    removed++;
                }
                parenthesis.pop();
            }
        }
        return builder.toString();
    }
}
