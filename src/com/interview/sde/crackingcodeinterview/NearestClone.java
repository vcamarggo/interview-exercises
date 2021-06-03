package com.interview.sde.crackingcodeinterview;

import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/find-the-nearest-clone/problem
public class NearestClone {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] verticesEdges = scanner.readLine().split(" ");

        int verticesNumber = Integer.parseInt(verticesEdges[0]);
        int edgesNumber = Integer.parseInt(verticesEdges[1]);

        ArrayList<Integer>[] edges = new ArrayList[verticesNumber + 1];
        for (int i = 0; i < verticesNumber; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgesNumber; i++) {
            String[] fromTo = scanner.readLine().split(" ");
            int from = Integer.parseInt(fromTo[0]) - 1;
            int to = Integer.parseInt(fromTo[1]) - 1;
            edges[to].add(from);
            edges[from].add(to);
        }

        String[] colorsString = scanner.readLine().split(" ");
        int[] colors = new int[colorsString.length];
        int targetColor = Integer.parseInt(scanner.readLine());

        scanner.close();

        int counter = 0;
        for (int i = 0; i < colorsString.length; i++) {
            int color = Integer.parseInt(colorsString[i]);
            colors[i] = color;
            if (color == targetColor) {
                counter++;
            }
        }
        if (counter > 1) {
            int min = Integer.MAX_VALUE;

            for (int startNode = 1; startNode < verticesNumber; startNode++) {
                if (colors[startNode] == targetColor) {
                    int[] distances = new int[verticesNumber + 1];

                    Arrays.fill(distances, Integer.MAX_VALUE);
                    distances[startNode] = 0;

                    Queue<Integer> processing = new LinkedList<>();
                    processing.add(startNode);
                    HashSet<Integer> visited = new HashSet<>();

                    while (!processing.isEmpty()) {
                        Integer node = processing.poll();

                        if (colors[startNode] == colors[node] && node != startNode) {
                            min = Math.min(distances[node], min);
                            break;
                        }

                        for (Integer edge : edges[node]) {
                            if (!visited.contains(edge)) {
                                processing.add(edge);
                                distances[edge] = distances[node] + 1;
                                visited.add(edge);
                            }
                        }
                    }
                    if (min == startNode) {
                        break;
                    }
                }
            }
            bufferedWriter.write(String.valueOf(min));
        } else {
            bufferedWriter.write(String.valueOf(-1));
        }
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
