package com.interview.sde.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/basic-calculator-ii/
public class BasicCalculatorII {

    public int calculate(String s) {
        Deque<Integer> calcStack = new ArrayDeque<>();

        StringBuilder operand = new StringBuilder();

        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) {
                if (Character.isDigit(c)) {
                    operand.append(c);
                } else {
                    executeOperationOnOperand(calcStack, operand, operation);
                    operation = c;
                    operand.setLength(0);
                }
            }
        }

        if (operand.length() > 0) {
            executeOperationOnOperand(calcStack, operand, operation);
        }

        int result = 0;
        while (!calcStack.isEmpty()) {
            result += calcStack.pop();
        }
        return result;
    }

    private void executeOperationOnOperand(Deque<Integer> calcStack, StringBuilder operand, char operation) {
        switch (operation) {
            case '+':
                calcStack.push(Integer.valueOf(operand.toString()));
                break;
            case '-':
                calcStack.push(-Integer.parseInt(operand.toString()));
                break;
            case '/':
                calcStack.push(calcStack.pop() / Integer.parseInt(operand.toString()));
                break;
            case '*':
                calcStack.push(calcStack.pop() * Integer.parseInt(operand.toString()));
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate("500 / 20 + 1"));
        System.out.println(new BasicCalculatorII().calculate(" 3+5 / 2 "));
        System.out.println(new BasicCalculatorII().calculate("3+2*2"));
    }
}
