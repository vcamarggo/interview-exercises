package com.interview.sde.java.backtracking;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/letter-tile-possibilities/
public class TilesCombinationsCount {
    public int numTilePossibilities(String tiles) {
        //Use set to deal with repeated tiles
        Set<String> solutions = new HashSet<>();

        for (char c : tiles.toCharArray()) {

            Set<String> tempSolution = new HashSet<>();
            //Add the single char
            tempSolution.add(String.valueOf(c));

            for (String sol : solutions) {
                //Generate all permutations of previous solutions added the current char
                for (int i = 0; i <= sol.length(); i++) {
                    tempSolution.add(sol.substring(0, i) + c + sol.substring(i));
                }
            }

            //Copy all the new generated solutions to the previous set
            solutions.addAll(tempSolution);

        }
        return solutions.size();
    }

    public static void main(String[] args) {
        System.out.println(new TilesCombinationsCount().numTilePossibilities("AAB"));
        System.out.println(new TilesCombinationsCount().numTilePossibilities("AAABBC"));
        System.out.println(new TilesCombinationsCount().numTilePossibilities("V"));
    }
}
