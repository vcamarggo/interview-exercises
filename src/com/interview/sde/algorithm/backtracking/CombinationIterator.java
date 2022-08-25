package com.interview.sde.algorithm.backtracking;

//https://leetcode.com/problems/iterator-for-combination/
public class CombinationIterator {

    private final String chars;
    private final int combinationLength;
    private final int[] lastIndexUsedForPosition;
    private boolean hasNext;

    int maxCharIndexAtPositionZero;

    public CombinationIterator(String characters, int combinationLength) {
        this.chars = characters;
        this.combinationLength = combinationLength;
        this.lastIndexUsedForPosition = new int[combinationLength];

        //Required to initialize the first string
        for (int i = 0; i < combinationLength; i++) {
            lastIndexUsedForPosition[i] = i;
        }

        this.hasNext = combinationLength <= characters.length();

        this.maxCharIndexAtPositionZero = chars.length() - combinationLength;
    }

    public String next() {
        return combine();
    }

    public boolean hasNext() {
        return hasNext;
    }

    public String combine() {
        hasNext = false;

        StringBuilder combination = new StringBuilder();
        for (int idx : lastIndexUsedForPosition) {
            combination.append(chars.charAt(idx));
        }

        int indexToChange = combinationLength - 1;
        while (indexToChange >= 0 && lastIndexUsedForPosition[indexToChange] == maxCharIndexAtPositionZero + indexToChange) {
            indexToChange--;
        }

        //indexToChange >= 0 indicates that a change still possible for next char
        if (indexToChange >= 0) {
            lastIndexUsedForPosition[indexToChange]++;
            for (int j = indexToChange + 1; j < combinationLength; j++) {
                // assign to each j the first element that is bigger than the previous
                lastIndexUsedForPosition[j] = lastIndexUsedForPosition[j - 1] + 1;
            }
            hasNext = true;
        }

        return combination.toString();
    }


    public static void main(String[] args) {
        CombinationIterator ci = new CombinationIterator("abcdefg", 3);
        while (ci.hasNext())
            System.out.println(ci.next());
    }

}
