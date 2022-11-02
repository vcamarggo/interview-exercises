package com.interview.sde.java.string;

import java.math.BigInteger;

//https://leetcode.com/problems/string-to-integer-atoi/
public class AtoI {
    public int myAtoi(String s) {
        boolean digitStarted = false;
        boolean digitFinished = false;
        boolean foundDigit = false;

        StringBuilder digits = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!digitFinished) {
                if (!digitStarted && (c == '-' || c == '+')) {
                    digits.append(c);
                    digitStarted = true;
                } else if (Character.isDigit(c)) {
                    digits.append(c);
                    digitStarted = true;
                    foundDigit = true;
                } else if (digitStarted) {
                    digitFinished = true;
                } else if (c != ' ') {
                    return 0;
                }
            }
        }

        if (digits.length() == 0 || !foundDigit) {
            return 0;
        }

        BigInteger digitsValue = new BigInteger(digits.toString());

        if (digitsValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        }

        if (digitsValue.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE;
        }


        return digitsValue.intValue();
    }
}
