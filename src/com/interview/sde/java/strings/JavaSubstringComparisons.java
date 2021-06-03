package com.interview.sde.java.strings;

import java.util.ArrayList;

//https://www.hackerrank.com/challenges/java-string-compare/problem
public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest;
        String largest;

        ArrayList<String> mySubs = new ArrayList<>();

        for (int i = 0; i + k <= s.length(); i++) {
            mySubs.add(s.substring(i, i + k));
        }
        java.util.Collections.sort(mySubs);

        smallest = mySubs.get(0);
        largest = mySubs.get(mySubs.size() - 1);

        return smallest + "\n" + largest;
    }


}
