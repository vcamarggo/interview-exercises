package com.interview.sde.algorithm.sorting;

//https://leetcode.com/problems/verifying-an-alien-dictionary/
public class SortCustomAlphabet {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    static boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int charIndex = 0; charIndex < words[i].length(); charIndex++) {

                if (charIndex == words[i + 1].length()) {
                    return false;
                }

                char charFromI = words[i].charAt(charIndex);
                char charFromI2 = words[i + 1].charAt(charIndex);
                if (charFromI != charFromI2) {
                    if (order.indexOf(charFromI) > order.indexOf(charFromI2)) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}
