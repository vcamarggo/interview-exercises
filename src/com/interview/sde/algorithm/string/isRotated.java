package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/rotate-string/
public class isRotated {
    static boolean rotateString(String a, String b) {
        return a.length() == b.length() && (a.equals(b) || (a + a).contains(b));
    }


    public static void main(String[] args) {
        System.out.println(rotateString("", ""));
    }

}
