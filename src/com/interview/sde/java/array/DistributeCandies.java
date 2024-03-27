package com.interview.sde.java.array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/distribute-candies/
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        return Math.min(Arrays.stream(candyType).boxed().collect(Collectors.toSet()).size(), candyType.length / 2);
    }

    public int distributeCandiesShortCircuit(int[] candyType) {
        int halfCandyType = candyType.length / 2;
        Set<Integer> candies = new HashSet<>(halfCandyType);
        for (int candy : candyType) {
            candies.add(candy);
            if(candies.size() == halfCandyType) return halfCandyType;
        }
        return candies.size();
    }
}
