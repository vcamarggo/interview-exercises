package com.interview.sde.java.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/palindrome-number
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        Deque<Integer> number = new ArrayDeque<>();
        Deque<Integer> reversedNumber = new ArrayDeque<>();

        int digits = x;
        while (digits > 0) {
            number.push(digits % 10);
            digits = digits / 10;
        }

        int index = number.size() / 2;
        while (index > 0) {
            reversedNumber.push(number.pop());
            index--;
        }

        if (number.size() != reversedNumber.size()) {
            number.pop();
        }

        while (!number.isEmpty()) {
            if (!number.peek().equals(reversedNumber.peek())) return false;
            number.pop();
            reversedNumber.pop();
        }

        return true;
    }
}
