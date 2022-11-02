package com.interview.sde.java.string;

//https://leetcode.com/problems/excel-sheet-column-number
public class ExcelColumns {
    static int titleToNumber(String columnTitle) {
        int solution = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            solution = solution * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("C"));
    }
}
