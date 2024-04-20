package com.interview.sde.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/check-array-formation-through-concatenation/
public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, List<Integer>> piecesMap = new HashMap<>(pieces.length);

        for (int[] piece : pieces) {
            List<Integer> ints = new ArrayList<>(piece.length);
            for (int i : piece) {
                ints.add(i);
            }
            piecesMap.put(piece[0], ints); // this is safe because all pieces are unique, else, we would need to use List<List<Integer>>
        }

        return canFormArray(arr, piecesMap, 0);
    }

    private boolean canFormArray(int[] arr, Map<Integer, List<Integer>> piecesMap, int idx) {
        if (idx >= arr.length) return true;
        if (!piecesMap.containsKey(arr[idx])) return false;
        List<Integer> possiblePieces = piecesMap.get(arr[idx]);
        for (int i = 0; i < possiblePieces.size(); i++) {
            if (arr[idx + i] != possiblePieces.get(i)) break;
            if (i == possiblePieces.size() - 1) return canFormArray(arr, piecesMap, idx + i + 1);
        }
        return false;
    }
}
