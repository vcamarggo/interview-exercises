package com.interview.sde.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/all-paths-from-source-to-target/
public class FindAllPaths {
    public static void main(String[] args) {
        new FindAllPaths().allPathsSourceTarget(new int[][]{
                new int[]{4,3,1},
                new int[]{3,2,4},
                new int[]{3},
                new int[]{4} ,
                new int[]{}});
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> paths = new LinkedList<>();

        for(int to = 0; graph[0].length > to ; to++){
            List<Integer> l = new ArrayList<>();
            l.add(0);
            l.add(graph[0][to]);
            paths.offer(l);
        }

        while(!paths.isEmpty()){
            List<Integer> l = paths.poll();
            int lastElement = l.get(l.size() - 1);

            if(lastElement == graph.length -1){
                result.add(l);
                continue;
            }

            for(int to = 0; graph[lastElement].length > to ; to++){
                List<Integer> newL = new ArrayList<>(l);
                newL.add(graph[lastElement][to]);
                paths.offer(newL);
            }

        }
        return result;
    }
}
