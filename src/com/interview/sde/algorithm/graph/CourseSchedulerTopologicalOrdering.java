package com.interview.sde.algorithm.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule
public class CourseSchedulerTopologicalOrdering {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> outEdges = new HashMap<>();
        int[] inEdges = new int[numCourses];
        int courseFulfilledPrerequisites = 0;

        for (int[] edge : prerequisites) {
            //In is the first one because it depends on the second
            int in = edge[0];
            int out = edge[1];

            outEdges.computeIfAbsent(out, k -> new ArrayList<>()).add(in);

            inEdges[in]++;
        }
        Queue<Integer> emptyInEdge = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inEdges[i] == 0) {
                emptyInEdge.offer(i);
            }
        }

        while (!emptyInEdge.isEmpty()) {
            int node = emptyInEdge.poll();
            courseFulfilledPrerequisites++;
            for (int neighbor : outEdges.getOrDefault(node, new ArrayList<>())) {
                inEdges[neighbor]--;
                if (inEdges[neighbor] == 0) {
                    emptyInEdge.offer(neighbor);
                }
            }
        }

        return courseFulfilledPrerequisites == numCourses;
    }
}
