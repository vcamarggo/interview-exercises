package com.interview.sde.algorithm.stack;

import java.util.Stack;
import java.util.function.Predicate;

//https://leetcode.com/problems/decode-string/
public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> patternStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder textSubPattern = extractDataFromStack(patternStack, stack -> !Character.isDigit(stack.peek()));

                //Keep adding the digits sub pattern to a string builder
                StringBuilder digitsSubPattern = extractDataFromStack(patternStack, stack -> !stack.isEmpty() && Character.isDigit(stack.peek()));
                int repeat = Integer.parseInt(digitsSubPattern.toString());

                //Repeat the sub pattern N times, the last char is the repetition digit
                addRepeatSubPatternToStack(patternStack, textSubPattern, repeat);
            } else {
                patternStack.push(c);
            }
        }

        return convertStackToString(patternStack);
    }

    private StringBuilder extractDataFromStack(Stack<Character> stack, Predicate<Stack<Character>> characterFilter) {
        StringBuilder sb = new StringBuilder();
        //Keep adding the chars from sub pattern to a string builder while filter is valid
        while (characterFilter.test(stack)) {
            sb.append(stack.pop());
        }
        //reverse the sub pattern to compensate the stack effect
        sb.reverse();
        return sb;
    }

    private String convertStackToString(Stack<Character> patternStack) {
        StringBuilder result = new StringBuilder(patternStack.size());
        while (!patternStack.isEmpty()) {
            result.append(patternStack.pop());
        }
        return result.reverse().toString().replaceAll("\\[", "");
    }

    private void addRepeatSubPatternToStack(Stack<Character> patternStack, StringBuilder subPattern, int repeat) {
        int sbLength = subPattern.length();
        for (int i = 0; i < repeat * sbLength; i++) {
            patternStack.push(subPattern.charAt(i % sbLength));
        }
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
        System.out.println(new DecodeString().decodeString("10[leetcode]"));
        System.out.println(new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
