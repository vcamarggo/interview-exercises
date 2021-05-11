package com.interview.sde.hackerrank.algorithm.stack;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation
public class ReversePolishNotation {
    static int evalRPN(String[] tokens) {
        Stack<Integer> elements = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int right = elements.pop();
                    int left = elements.pop();
                    elements.push(left + right);
                    break;
                }
                case "-": {
                    int right = elements.pop();
                    int left = elements.pop();
                    elements.push(left - right);
                    break;
                }
                case "*": {
                    int right = elements.pop();
                    int left = elements.pop();
                    elements.push(left * right);
                    break;
                }
                case "/": {
                    int right = elements.pop();
                    int left = elements.pop();
                    elements.push(left / right);
                    break;
                }
                default:
                    elements.push(Integer.parseInt(token));
                    break;
            }
        }
        return elements.peek();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
