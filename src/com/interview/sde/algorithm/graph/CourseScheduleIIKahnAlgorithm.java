package com.interview.sde.algorithm.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleIIKahnAlgorithm {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(findOrder(4,
                        new int[][]{
                                new int[]{1, 0},
                                new int[]{2, 0},
                                new int[]{3, 1},
                                new int[]{3, 2},
                        })));
    }

    static int[] topologicalOrderKahnAlgorithm(int numCourses, int[][] prerequisites) {

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

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        return topologicalOrderKahnAlgorithm(numCourses, prerequisites);
    }
}
