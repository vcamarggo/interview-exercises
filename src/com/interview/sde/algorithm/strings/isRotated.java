package com.interview.sde.algorithm.strings;

//https://leetcode.com/problems/rotate-string/
public class isRotated {
    static boolean rotateString(String a, String b) {
        int aSize = a.length();
        if (aSize != b.length()) {
            return false;
        }

        if (a.equals(b)) {
            return true;
        }

        int startIndex = 0;
        while (startIndex != -1) {
            boolean solutionFound = true;


            for (int i = 0; i < aSize; i++) {

                int bIndex = startIndex + i;

                if (bIndex >= aSize) {
                    bIndex -= aSize;
                }

                if (a.charAt(i) != b.charAt(bIndex)) {
                    solutionFound = false;
                    break;
                }
            }

            startIndex = b.indexOf(a.charAt(0), startIndex + 1);

            if (solutionFound) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(rotateString("", ""));
    }

}
