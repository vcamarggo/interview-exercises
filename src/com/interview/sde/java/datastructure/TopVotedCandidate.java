package com.interview.sde.java.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/online-election/
public class TopVotedCandidate {

    private final TreeMap<Integer, Integer> electionBoard;

    public TopVotedCandidate(int[] persons, int[] times) {
        electionBoard = new TreeMap<>();
        Map<Integer, Integer> electionAgg = new HashMap<>(5000);

        int maxIndex = 0;

        for (int i = 0; i < times.length; i++) {
            electionAgg.put(persons[i], electionAgg.getOrDefault(persons[i], 0) + 1);
            if (electionAgg.get(persons[i]) >= electionAgg.getOrDefault(maxIndex, Integer.MIN_VALUE)) {
                maxIndex = persons[i];
            }
            electionBoard.put(times[i], maxIndex);
        }
    }

    public int q(int t) {
        return electionBoard.floorEntry(t).getValue();
    }

}
