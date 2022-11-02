package com.interview.sde.algorithm.graph;

import java.util.*;

//https://leetcode.com/problems/reconstruct-itinerary/
public class ReconstructItinerary {
    public static void main(String[] args) {
        System.out.println(new ReconstructItinerary().findItinerary(List.of(
                List.of("JFK", "KUL"),
                List.of("JFK", "NRT"),
                List.of("NRT", "JFK"))));
    }

    List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> airportPriority = new HashMap<>(tickets.size());
        for (List<String> flight : tickets) {
            String from = flight.get(0);
            String to = flight.get(1);
            airportPriority.computeIfAbsent(from, key -> new PriorityQueue<>()).add(to);
        }
        return travel("JFK", airportPriority);
    }

    List<String> travel(String from, Map<String, PriorityQueue<String>> targets) {
        List<String> solution = new ArrayList<>();
        while (targets.containsKey(from) && !targets.get(from).isEmpty()) {
            String to = targets.get(from).poll();
            solution.addAll(0, travel(to, targets));
        }
        solution.add(0, from);
        return solution;
    }
}
