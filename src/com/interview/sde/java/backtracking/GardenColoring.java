package com.interview.sde.java.backtracking;

import java.util.*;

//https://leetcode.com/problems/flower-planting-with-no-adjacent/
public class GardenColoring {
    public int[] gardenNoAdj(int numberGardens, int[][] pathsBetweenGardens) {

        final int MAX_COLORS = 4;

        int[] solution = new int[numberGardens];
        int[] solutionTried = new int[numberGardens];

        HashMap<Integer, Set<Integer>> lookupTable = buildLookupTable(pathsBetweenGardens);

        for (int garden = 1; garden <= numberGardens; garden++) {

            for (int color = solutionTried[garden - 1] + 1; color <= MAX_COLORS; color++) {
                solutionTried[garden - 1] = color;
                if (isSolutionValid(garden, color, solution, lookupTable)) {
                    solution[garden - 1] = color;
                    break;
                }
            }

            if (!foundSolution(garden, solution)) {
                solutionTried[garden - 1] = 0; // Reset the solutions tried, as no solution was found, otherwise, would be stuck as max color number
                garden -= 2; //A type of iterative backtracking. I'm not happy with this solution, but it works for now.
            }
        }

        return solution;
    }

    //Backtracking implementation. Not using call stack, seems that still room to better implementation
    public int[] gardenNoAdjBacktracking(int numberGardens, int[][] pathsBetweenGardens) {

        HashMap<Integer, Set<Integer>> lookupTable = buildLookupTable(pathsBetweenGardens);

        return gardenNoAdjBacktrackingInternal(numberGardens, 1, 1, new ArrayList<>(), lookupTable).stream().mapToInt(integer -> integer).toArray();
    }

    private List<Integer> gardenNoAdjBacktrackingInternal(final int numberGardens, int garden, final int color, List<Integer> solution, HashMap<Integer, Set<Integer>> lookupTable) {
        final int MAX_COLORS = 4;

        for (int tryColor = color; tryColor <= MAX_COLORS; tryColor++) {
            if (solution.size() >= numberGardens) {
                return solution;
            }
            if (isSolutionValidBacktracking(garden, tryColor, solution, lookupTable)) {
                solution.add(tryColor);
                gardenNoAdjBacktrackingInternal(numberGardens, garden + 1, 1, solution, lookupTable);
            }
        }

        if (solution.size() < garden) {
            int colorUsed = solution.remove(garden - 1);
            gardenNoAdjBacktrackingInternal(numberGardens, garden - 1, colorUsed + 1, solution, lookupTable);
        }

        return solution;
    }

    private boolean foundSolution(int garden, int[] solution) {
        return solution[garden - 1] == 0;
    }

    private HashMap<Integer, Set<Integer>> buildLookupTable(int[][] paths) {
        HashMap<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int[] path : paths) {
            Set<Integer> neighborsSet0 = neighbors.getOrDefault(path[0], new HashSet<>());
            neighborsSet0.add(path[1]);
            neighbors.put(path[0], neighborsSet0);
            Set<Integer> neighborsSet1 = neighbors.getOrDefault(path[1], new HashSet<>());
            neighborsSet1.add(path[0]);
            neighbors.put(path[1], neighborsSet1);
        }
        return neighbors;
    }

    //Using lookup table makes the algorithm 30x faster
    private boolean isSolutionValid(int garden, int color, int[] solution, HashMap<Integer, Set<Integer>> lookupTable) {
        if (lookupTable.containsKey(garden)) {
            for (Integer neighbor : lookupTable.get(garden)) {
                if (color == solution[neighbor - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSolutionValidBacktracking(int garden, int color, List<Integer> solution, HashMap<Integer, Set<Integer>> lookupTable) {
        if (lookupTable.containsKey(garden)) {
            for (Integer neighbor : lookupTable.get(garden)) {
                if (solution.size() >= neighbor - 1 && color == solution.get(neighbor - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Search across all paths. Not used.
    // Maybe sorting the list based on [0] and also a sorted copy based on [1] would allow a shorter search space,
    // as everything bigger than garden wouldn't need to be searched for.
    // The search is incremental in relation to garden, so only a few times all space would be queried
    private boolean isSolutionValid(int garden, int color, int[] solution, int[][] paths) {
        for (int[] path : paths) {
            if (path[0] == garden && color == solution[path[1] - 1] || path[1] == garden && color == solution[path[0] - 1]) {
                return false;
            }
        }
        return true;
    }

}
