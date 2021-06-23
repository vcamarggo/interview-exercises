package com.interview.sde.algorithm.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule
//Timeout
public class CourseSchedulerCycleDetection {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int[] edgeData : prerequisites) {
            List<Integer> edges = adjacencyList.getOrDefault(edgeData[1], new ArrayList<>());
            edges.add(edgeData[0]);
            adjacencyList.put(edgeData[1], edges);
        }
        return !graphHasCycle(numCourses, adjacencyList);
    }

    private static boolean graphHasCycle(int numCourses, Map<Integer, List<Integer>> adjacencyList) {
        Set<Integer> visited = new HashSet<>();

        for (int node = 0; node < numCourses; node++) {
            if (isCycle(node, adjacencyList, visited)) {
                return true;
            }
        }

        return false;
    }


    private static boolean isCycle(final int node, Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited) {

        if (visited.contains(node)) {
            return true;
        }

        visited.add(node);

        for (Integer adjacency : adjacencyList.getOrDefault(node, new ArrayList<>())) {
            if (isCycle(adjacency, adjacencyList, visited) || visited.contains(node)) {
                return true;
            }
        }

        visited.remove(node);

        return false;
    }
}
