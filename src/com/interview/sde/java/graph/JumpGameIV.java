package com.interview.sde.java.graph;

import java.util.*;

//https://leetcode.com/problems/jump-game-iv/
public class JumpGameIV {

    List<Integer> empty = Collections.emptyList();

    public static void main(String[] args) {
//        new JumpGameIV().minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
//        new JumpGameIV().minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7});
        new JumpGameIV().minJumps(new int[]{7, 7, 7, 11});
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            indexes.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> toProcess = new LinkedList<>();
        toProcess.offer(0);

        int steps = 0;

        while (!toProcess.isEmpty()) {

            int remaining = toProcess.size();
            while (remaining-- > 0) {
                int position = toProcess.poll();

                if (position < 0 || position > arr.length) {
                    continue;
                }

                if (position == arr.length - 1) {
                    return steps;
                }

                int value = arr[position];

                for (int idx : indexes.getOrDefault(value, empty)) {
                    if (idx != position)
                        toProcess.add(idx);
                }
                indexes.remove(value);

                if (position > 0 && indexes.containsKey(arr[position - 1])) {
                    toProcess.add(position - 1);
                }
                if (position < arr.length - 1 && indexes.containsKey(arr[position + 1])) {
                    toProcess.add(position + 1);
                }
            }
            steps++;
        }

        return -1;
    }
}
