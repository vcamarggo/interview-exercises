package com.interview.sde.java.string;

//https://leetcode.com/problems/greatest-common-divisor-of-strings/
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("AA", "A"));
    }

    static String gcdOfStrings(String s, String t) {
        int minLength = Math.min(s.length(), t.length());

        String minString = minLength == s.length() ? s : t;
        String maxString = minLength == s.length() ? t : s;

        // start with the largest string
        for (int i = minLength; i >= 1; i--) {
            if (minLength % i == 0) { //if string can be split in parts of the same size
                String mustBeEqual = minString.substring(0, i);
                boolean allEqual = true;

                //test all string starting at 0+offset i
                for (int internalIndex = i; internalIndex < minLength; internalIndex += i) {
                    if (!minString.substring(internalIndex, internalIndex + i).equals(mustBeEqual)) {
                        allEqual = false;
                        break;
                    }
                }

                if (allEqual && otherStillSamePattern(maxString, mustBeEqual)) {
                    return mustBeEqual;
                }
            }
        }

        return "";
    }

    static boolean otherStillSamePattern(String str, String mustBeEqual) {
        int offset = mustBeEqual.length();
        for (int internalIndex = 0; internalIndex < str.length(); internalIndex += offset) {
            if (internalIndex + offset > str.length() || !str.substring(internalIndex, internalIndex + offset).equals(mustBeEqual)) {
                return false;
            }
        }
        return true;
    }
}
