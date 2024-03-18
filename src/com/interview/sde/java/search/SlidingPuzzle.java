package com.interview.sde.java.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/sliding-puzzle/
public class SlidingPuzzle {
    final String solution = "123450";
    final Set<String> visited = new HashSet<>();
    Queue<StringDepth> processStructure = new LinkedList<>();

    private static String swap(String data, int i, int j) {
        StringBuilder sb = new StringBuilder(data);
        sb.setCharAt(i, data.charAt(j));
        sb.setCharAt(j, data.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SlidingPuzzle().slidingPuzzle(new int[][]{new int[]{4, 1, 2}, new int[]{5, 0, 3}}));
    }

    int slidingPuzzle(int[][] board) {

        processStructure.add(new StringDepth(generateFirstSolution(board), 0));

        while (!processStructure.isEmpty()) {

            StringDepth node = processStructure.poll();
            if (node.data.equals(solution)) {
                return node.depth;
            }
            visited.add(node.data);

            switch (node.emptyIndex) {
                case 0:
                    slideNode(node, 3, 0);
                    slideNode(node, 1, 0);
                    break;
                case 1:
                    slideNode(node, 4, 1);
                    slideNode(node, 2, 1);
                    slideNode(node, 0, 1);
                    break;
                case 2:
                    slideNode(node, 5, 2);
                    slideNode(node, 1, 2);
                    break;
                case 3:
                    slideNode(node, 0, 3);
                    slideNode(node, 4, 3);
                    break;
                case 4:
                    slideNode(node, 1, 4);
                    slideNode(node, 3, 4);
                    slideNode(node, 5, 4);
                    break;
                case 5:
                    slideNode(node, 2, 5);
                    slideNode(node, 4, 5);
                    break;
            }

        }
        return -1;
    }

    private String generateFirstSolution(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(ints[j]);
            }
        }
        return sb.toString();
    }

    private void slideNode(StringDepth node, int i, int i2) {
        StringDepth slide = new StringDepth(swap(node.data, i, i2), node.depth + 1);
        if (!visited.contains(slide.data)) {
            visited.add(slide.data);
            processStructure.add(slide);
        }
    }

    static class StringDepth {
        String data;
        int depth;
        int emptyIndex;

        public StringDepth(String data, int depth) {
            this.data = data;
            this.depth = depth;
            this.emptyIndex = data.indexOf('0');
        }
    }
}
