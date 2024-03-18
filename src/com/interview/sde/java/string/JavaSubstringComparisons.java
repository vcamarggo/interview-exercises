package com.interview.sde.java.string;

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

        smallest = mySubs.getFirst();
        largest = mySubs.getLast();

        return smallest + "\n" + largest;
    }


}
