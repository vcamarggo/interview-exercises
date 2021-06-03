package com.interview.sde.algorithm.dynamicprogramming;

public class LCS {
    public static void main(String[] args) {
        String s1 = "GTACCGTCA";
        String s2 = "CATCGA";
        System.out.println(lcs(s1, s2));
    }

    private static String lcs(String s1, String s2) {
        int[][] lcsCounter = new int[s1.length() + 1][s2.length() + 1];

        for (int s1Index = 1; s1Index < lcsCounter.length; s1Index++) {
            for (int s2Index = 1; s2Index < lcsCounter[0].length; s2Index++) {
                if (s1.charAt(s1Index - 1) == s2.charAt(s2Index - 1)) {
                    lcsCounter[s1Index][s2Index] = lcsCounter[s1Index - 1][s2Index - 1] + 1;
                } else {
                    lcsCounter[s1Index][s2Index] = Math.max(lcsCounter[s1Index - 1][s2Index], lcsCounter[s1Index][s2Index - 1]);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        int s1Index = lcsCounter.length - 1;
        int s2Index = lcsCounter[0].length - 1;
        while (lcsCounter[lcsCounter.length - 1][lcsCounter[0].length - 1] > result.length()) {
            if (s1.charAt(s1Index - 1) == s2.charAt(s2Index - 1)) {
                result.insert(0, s1.charAt(s1Index - 1));
                s1Index--;
                s2Index--;
            } else if (lcsCounter[s1Index - 1][s2Index] > lcsCounter[s1Index][s2Index - 1]) {
                s1Index--;
            } else {
                s2Index--;
            }
        }

        return result.toString();
    }

}
