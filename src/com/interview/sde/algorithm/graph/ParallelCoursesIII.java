package com.interview.sde.algorithm.graph;

import java.util.*;
//https://leetcode.com/problems/parallel-courses-iii/
public class ParallelCoursesIII {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> outEdges = new HashMap<>(n + 1);
        int[] inEdgesCount = new int[n];
        Comparator<Integer> higherTimeFirst = (o1, o2) -> Integer.compare(time[o2], time[o1]);
        Queue<Integer> toProcess = new PriorityQueue<>(higherTimeFirst);

        int[] pathTime = new int[n];


        for (int[] edge : relations) {
            outEdges.computeIfAbsent(edge[0] - 1, k -> new ArrayList<>()).add(edge[1] - 1);
            inEdgesCount[edge[1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (inEdgesCount[i] == 0) {
                //the path to an element without predecessor is its own time
                pathTime[i] = time[i];
                toProcess.offer(i);
            }
        }

        while (!toProcess.isEmpty()) {
            int out = toProcess.poll();

            for (int in : outEdges.getOrDefault(out, new ArrayList<>())) {
                //the path to an element is the time to itself if no predecessor or the predecessor time plus its own time
                pathTime[in] = Math.max(pathTime[in], pathTime[out] + time[in]);

                if (--inEdgesCount[in] == 0) {
                    toProcess.offer(in);
                }
            }
        }

        return Arrays.stream(pathTime).max().getAsInt();
    }
}
