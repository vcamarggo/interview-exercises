package com.interview.sde.java.stack;

import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/
public class LongestParenthesis {

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses(")()())"));
//        System.out.println(longestValidParentheses("()"));
//        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("(((((()"));
    }

    static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            } else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
