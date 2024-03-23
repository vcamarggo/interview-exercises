package com.interview.sde.java.string;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(0));
        System.out.println(reverse(-1));
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        StringBuilder reversed = new StringBuilder(String.valueOf(x)).reverse();

        if (reversed.charAt(reversed.length() - 1) == '-') {
            reversed.insert(0, '-').deleteCharAt(reversed.length() - 1);
        }

        //Dirty move, but works for this context
        try {
            return Integer.parseInt(reversed.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
