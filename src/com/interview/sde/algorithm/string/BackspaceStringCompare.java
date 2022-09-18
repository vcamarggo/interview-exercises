package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/backspace-string-compare/
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {

        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;

        while (sIndex >= 0 || tIndex >= 0) {
            sIndex = clearBackspace(s, sIndex);

            tIndex = clearBackspace(t, tIndex);

            //If either one string finished and the other does not, or they char does not match, return false.
            if (sIndex < 0 && tIndex >= 0 || sIndex >= 0 && tIndex < 0 || sIndex >= 0 && s.charAt(sIndex) != t.charAt(tIndex)) {
                return false;
            } else {
                //else, update their index accordingly
                sIndex--;
                tIndex--;
            }
        }
        return sIndex == tIndex;
    }

    private static int clearBackspace(String str, int index) {
        while (index >= 0 && str.charAt(index) == '#') {
            int skipS = 1;
            index--;
            while (skipS > 0 && index >= 0) {
                if (str.charAt(index) == '#') {
                    skipS++;
                } else {
                    skipS--;
                }
                index--;
            }
        }
        return index;
    }
}
