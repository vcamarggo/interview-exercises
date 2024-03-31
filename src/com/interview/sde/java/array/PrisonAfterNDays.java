package com.interview.sde.java.array;

//https://leetcode.com/problems/prison-cells-after-n-days/
public class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {

        final int CYCLE_SIZE = 14;
        n = n % CYCLE_SIZE == 0 ? CYCLE_SIZE : n % CYCLE_SIZE;

        while (n-- > 0) {
            int[] tempCells = new int[8];
            for (int i = 1; i < 7; i++) {
                tempCells[i] = cells[i - 1] == 1 && cells[i + 1] == 1 || cells[i - 1] == 0 && cells[i + 1] == 0 ? 1 : 0;
            }
            cells = tempCells;
        }
        return cells;
    }
}
