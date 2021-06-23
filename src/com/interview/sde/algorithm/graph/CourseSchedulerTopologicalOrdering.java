package com.interview.sde.algorithm.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule
public class CourseSchedulerTopologicalOrdering {


    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
        System.out.println(canFinish(4, new int[][]{new int[]{2, 3}, new int[]{3, 2}}));
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}}));
        System.out.println(canFinish(2, new int[][]{new int[]{0, 1}}));
        System.out.println(canFinish(1, new int[][]{}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int[] edgeData : prerequisites) {
            int course = edgeData[0];
            int preRequisite = edgeData[1];

            List<Integer> edges = adjacencyList.getOrDefault(preRequisite, new ArrayList<>());
            if (!edges.contains(course)) {
                edges.add(course);
                inDegree[course]++;
            }
            adjacencyList.put(preRequisite, edges);

        }

        Queue<Integer> courseWithNoDependency = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                courseWithNoDependency.add(i);
            }
        }

        int courseFulfilledPrerequisites = 0;
        while (!courseWithNoDependency.isEmpty()) {
            int course = courseWithNoDependency.poll();
            courseFulfilledPrerequisites++;

            for (int dependsOnCourse : adjacencyList.getOrDefault(course, new ArrayList<>())) {
                if (--inDegree[dependsOnCourse] == 0) {
                    courseWithNoDependency.add(dependsOnCourse);
                }
            }
        }
        return courseFulfilledPrerequisites == numCourses;
    }


}
