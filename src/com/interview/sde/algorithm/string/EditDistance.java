package com.interview.sde.algorithm.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/edit-distance/
public class EditDistance {
    private final Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(new EditDistance().minDistance("horse", "ros"));
        System.out.println(new EditDistance().minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        if (memo.containsKey(word1 + "#" + word2)) {
            return memo.get(word1 + "#" + word2);
        }
        if (word1.length() == 0 || word2.length() == 0) {
            //one of them is empty, count the length of the other as the number of removals we need
            int distance = Math.max(word1.length(), word2.length());
            return memo.compute(word1 + "#" + word2, (k, v) -> distance);
        }
        if (word1.charAt(0) == word2.charAt(0)) {
            //no cost to remove chars that match
            int distance = minDistance(word1.substring(1), word2.substring(1));

            return memo.compute(word1.substring(1) + "#" + word2.substring(1), (k, v) -> distance);
        }
        //same as remove from w1
        //e.g. w1 = boros w2 = eros, w1 become oros.
        // The cost is 1
        int distanceRemove = minDistance(word1.substring(1), word2) + 1;

        //same as add something on w2, then remove the new char and remove the first char for word1 as they now match and removing equal chars has cost 0
        //e.g. w1 = boros w2 = eros, w2 become beros, then you can  remove b from both at no cost.
        // The cost is 1 from the first insert on w2
        int distanceInsert = minDistance(word1, word2.substring(1)) + 1;

        //same as change something on word2 or word1, then remove that from both as they now match and that has cost 0
        //e.g. w1 = boros w2 = neros, w2 become beros, then you can  remove b from both at no cost because they now match.
        // The cost is 1 from changing a char either on w1 or w2
        int distanceReplace = minDistance(word1.substring(1), word2.substring(1)) + 1;

        int distance = Math.min(Math.min(distanceRemove, distanceInsert), distanceReplace);

        return memo.compute(word1 + "#" + word2, (k, v) -> distance);
    }
}
