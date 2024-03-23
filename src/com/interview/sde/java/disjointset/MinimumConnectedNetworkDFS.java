package com.interview.sde.java.disjointset;

import java.util.*;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class MinimumConnectedNetworkDFS {

    Set<Integer> visited = new HashSet<>();
    Map<Integer, Set<Integer>> connectionsMapping = new HashMap<>();

    public int makeConnected(int n, int[][] connections) {
        //Minimum required connections to form a complete graph
        if (connections.length < n - 1) {
            return -1;
        }

        for (int[] connection : connections){
            connectionsMapping.computeIfAbsent(connection[0], k -> new HashSet<>()).add(connection[1]);
            connectionsMapping.computeIfAbsent(connection[1], k -> new HashSet<>()).add(connection[0]);
        }

        int unique = 0;
        for (int i = 0; i < n; i++) {
            if(!visited.contains(i) && connectionsMapping.containsKey(i))
                unique += dfs(i);
        }

        //Number of nodes, minus the number of already connected nodes as we would not need their connections, plus the number of not connected island of nodes - 1
        return n - visited.size() + unique - 1;
    }

    private int dfs(int start) {
        if(!visited.contains(start)){
            Deque<Integer> toProcess = new ArrayDeque<>();
            toProcess.add(start);
            while (!toProcess.isEmpty()){
                int from = toProcess.pop();
                visited.add(from);
                for (int to : connectionsMapping.get(from)){
                    if(!visited.contains(to)){
                        toProcess.push(to);
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        new MinimumConnectedNetworkDFS().makeConnected(11, new int[][]{{3, 4}, {5, 6}, {0, 3}, {0, 5}, {1, 7}, {0, 4}, {2, 6}, {1, 6}, {1, 3}, {3, 7}, {4, 5}, {3, 5}});
        new MinimumConnectedNetworkDFS().makeConnected(3, new int[][]{{0, 1}, {0, 2}});
        new MinimumConnectedNetworkDFS().makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3,4}, {2,3}});
        new MinimumConnectedNetworkDFS().makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0,3}, {1,2}});
    }
}
