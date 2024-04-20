package com.interview.sde.java.string;

//https://leetcode.com/problems/base-7/
public class IntToBase7String {
    public String convertToBase7(int num) {
        StringBuilder b7 = new StringBuilder();

        boolean negative = num < 0;

        if (negative) num *= -1;

        do {
            char digit = (char) (num % 7 + '0');
            b7.append(digit);
            num /= 7;
        } while (num > 0);

        if (negative) b7.append("-");

        return b7.reverse().toString();
    }
}
