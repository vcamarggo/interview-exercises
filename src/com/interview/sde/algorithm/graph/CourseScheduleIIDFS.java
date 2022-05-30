package com.interview.sde.algorithm.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleIIDFS {
    int postNumber;
    Set<Integer> visiting;
    Set<Integer> visited;
    boolean[][] edges;
    int[] postOrderNumber;
    boolean foundLoop;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return topologicalDfs(numCourses, prerequisites);
    }

    public int[] topologicalDfs(int numCourses, int[][] prerequisites) {
        postNumber = 0;
        visiting = new HashSet<>();
        visited = new HashSet<>();
        edges = new boolean[numCourses][numCourses];
        postOrderNumber = new int[numCourses];
        for (int[] edge : prerequisites) {
            //In is the first one because it depends on the second
            int in = edge[0];
            int out = edge[1];
            edges[out][in] = true;
        }

        for (int node = 0; node < edges.length; node++) {
            if (!visited.contains(node) && !visiting.contains(node)) {
                dfs(node);
            }
        }

        if (foundLoop) {
            return new int[]{};
        }

        // Fancy O(n) version
        int[] topologicalOrder = new int[postOrderNumber.length * 2];
        Arrays.fill(topologicalOrder, -1);

        for (int i = 0; i < postOrderNumber.length; i++) {
            topologicalOrder[postOrderNumber[i]] = i;
        }

        List<Integer> solution = new ArrayList<>();
        for (int i = topologicalOrder.length - 1; i >= 0; i--) {
            if (topologicalOrder[i] != -1) {
                solution.add(topologicalOrder[i]);
            }
        }
        return solution.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int node) {

        postNumber++;
        visiting.add(node);
        for (int destination = 0; destination < edges.length && !foundLoop; destination++) {
            if (edges[node][destination]) {
                if (visiting.contains(destination)) {
                    foundLoop = true;
                } else if (!visited.contains(destination)) {
                    dfs(destination);
                }
            }
        }
        visiting.remove(node);
        visited.add(node);
        postOrderNumber[node] = postNumber++;
    }
}
