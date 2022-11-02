package com.interview.sde.algorithm.queue;

import java.util.*;

//https://leetcode.com/problems/keys-and-rooms/
public class KeysAndRooms {

    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final Integer INITIAL_NODE = 0;

        Set<Integer> visited = new HashSet<>(rooms.size());
        Deque<Integer> toVisit = new LinkedList<>();
        toVisit.offerLast(INITIAL_NODE);
        visited.add(INITIAL_NODE);


        while (!toVisit.isEmpty()) {
            int current = toVisit.pollFirst();

            for (Integer neighbor : rooms.get(current)) {
                if (!visited.contains(neighbor)) {
                    toVisit.offerLast(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(new ArrayList<>());
        System.out.println(canVisitAllRooms(rooms));

        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(List.of(1, 3));
        rooms2.add(List.of(3, 0, 1));
        rooms2.add(List.of(2));
        rooms2.add(List.of(0));
        System.out.println(canVisitAllRooms(rooms2));
    }
}
