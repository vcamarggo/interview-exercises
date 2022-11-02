package com.interview.sde.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class RemoveMinimumValidParenthesis {

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses(")()())"));
//        System.out.println(longestValidParentheses("()"));
//        System.out.println(longestValidParentheses("(()"));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("(()))"));
        System.out.println(minRemoveToMakeValid(")))(("));
    }

    static String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            } else if(s.charAt(i) == ')'){
                if(stack.isEmpty() || s.charAt(stack.peek()) != '('){
                    stack.push(i);
                } else{
                    stack.pop();
                }
            }
        }

        StringBuilder solution = new StringBuilder(s);
        while (!stack.isEmpty()){
            solution.deleteCharAt(stack.pop());
        }
        return solution.toString();
    }
}
