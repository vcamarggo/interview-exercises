package com.interview.sde.algorithm.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(findOrder(9,
                        new int[][]{
                                new int[]{1, 4},
                                new int[]{2, 1},
                                new int[]{2, 3},
                                new int[]{2, 5},
                                new int[]{3, 6},
                                new int[]{4, 5},
                                new int[]{4, 7},
                                new int[]{4, 8},
                                new int[]{5, 7},
                                new int[]{6, 7},
                                new int[]{6, 8},
                                new int[]{7, 8}
                        })));
    }

    static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> outEdges = new HashMap<>();
        int[] inEdges = new int[numCourses];
        int[] solution = new int[numCourses];
        int solutionIndex = 0;

        for (int[] edge : prerequisites) {
            //In is the first one because it depends on the second
            int in = edge[0];
            int out = edge[1];
            List<Integer> outList = outEdges.getOrDefault(out, new ArrayList<>());
            outList.add(in);
            outEdges.put(out, outList);

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
            solution[solutionIndex++] = node;
            for (int neighbor : outEdges.getOrDefault(node, new ArrayList<>())) {
                inEdges[neighbor]--;
                if (inEdges[neighbor] == 0) {
                    emptyInEdge.offer(neighbor);
                }
            }
        }

        return solutionIndex == numCourses ? solution : new int[]{};
    }
}
