package com.interview.sde.java.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {
    static List<String> generateParenthesis(int n) {
        return generateParentheses(n, n, new StringBuilder());
    }

    static List<String> generateParentheses(int remainingOpen, int remainingClose, StringBuilder solution) {
        if (remainingClose == 0 && remainingOpen == 0) {
            return List.of(solution.toString());
        }

        List<String> parentheses = new ArrayList<>();
        if (remainingOpen > 0) {
            solution.append("(");
            parentheses.addAll(generateParentheses(remainingOpen - 1, remainingClose, solution));
            solution.deleteCharAt(solution.length() - 1);
        }

        //This tests if there is any parenthesis unclosed in the solution
        if (remainingClose > remainingOpen) {
            solution.append(")");
            parentheses.addAll(generateParentheses(remainingOpen, remainingClose - 1, solution));
            solution.deleteCharAt(solution.length() - 1);
        }
        return parentheses;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
