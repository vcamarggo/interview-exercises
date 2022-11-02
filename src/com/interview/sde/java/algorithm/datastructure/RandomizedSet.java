package com.interview.sde.algorithm.datastructure;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//https://leetcode.com/problems/insert-delete-getrandom-o1
public class RandomizedSet {
    Set<Integer> dataSet;
    Integer[] fastAccessData;
    boolean dataChanged;

    Random randomNumberGenerator;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        dataSet = new HashSet<>();
        randomNumberGenerator = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (dataSet.add(val)) {
            dataChanged = true;
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (dataSet.remove(val)) {
            dataChanged = true;
            return true;
        }
        return false;
    }

    // O(n) instead of O(1), as the full set is being converted to Array
    // If the data has not changed, a new array is not created

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (dataChanged) {
            fastAccessData = dataSet.toArray(new Integer[0]);
            dataChanged = false;
        }
        return fastAccessData[randomNumberGenerator.nextInt(dataSet.size())];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

