package com.interview.sde.java.search;

import java.util.TreeSet;

//https://leetcode.com/problems/smallest-number-in-infinite-set/
public class MinInfiniteSet {

    int min = 1;
    TreeSet<Integer> readded = new TreeSet<>();

    public MinInfiniteSet() {

    }

    public int popSmallest() {
        return !readded.isEmpty() ? readded.removeFirst() : min++;
    }

    public void addBack(int num) {
        if (num < min) {
            readded.add(num);
        }
    }
}
