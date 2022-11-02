package com.interview.sde.java.disjointset;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/torque-and-development/problem
//Solved using Disjoint Set
public class RoadAndLibraries {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib <= c_road) {
            return (long) n * (long) c_lib;
        }
        DisjointSet dj = new DisjointSet(n);
        for (int[] city : cities) {
            dj.unionSets(city[0], city[1]);
        }

        long result = 0;
        for (long size : dj.getComponentsSize()) {
            result += ((size - 1) * c_road + c_lib);
        }
        return result;
    }

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            System.out.println(result);
        }

        scanner.close();
    }

    private static class DisjointSet {
        private final int[] sets;
        private final long[] size;

        public DisjointSet(int n) {
            this.sets = new int[n + 1];
            this.size = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                sets[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int i) {
            while (sets[i] != i) {
                i = sets[i];
            }
            return i;
        }

        void unionSets(int a, int b) {
            int aParent = findParent(a);
            int bParent = findParent(b);
            if (aParent != bParent) {
                int min = Math.min(aParent, bParent);
                int max = Math.max(aParent, bParent);
                size[max] += size[min];
                sets[min] = max;
            }
        }

        Collection<Long> getComponentsSize() {
            HashMap<Integer, Long> uniqueSizesMap = new HashMap<>();
            for (int i = 1; i < size.length; i++) {
                int key = findParent(i);
                if (!uniqueSizesMap.containsKey(key))
                    uniqueSizesMap.put(sets[key], size[key]);
            }
            return uniqueSizesMap.values();
        }

    }


}

