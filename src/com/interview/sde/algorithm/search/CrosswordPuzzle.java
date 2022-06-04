package com.interview.sde.algorithm.search;

import java.util.*;

//https://www.hackerrank.com/challenges/crossword-puzzle/problem
public class CrosswordPuzzle {
    static List<String> solution = new ArrayList<>();

    public static void main(String[] args) {
        List<String> crossword = new ArrayList<>();
        crossword.add("++++++++++");
        crossword.add("+------+++");
        crossword.add("+++-++++++");
        crossword.add("+++-++++++");
        crossword.add("+++-----++");
        crossword.add("+++-++-+++");
        crossword.add("++++++-+++");
        crossword.add("++++++-+++");
        crossword.add("++++++-+++");
        crossword.add("++++++++++");
        System.out.println(crosswordPuzzle(crossword, "POLAND;LHASA;SPAIN;INDIA"));
    }

    public static List<String> crosswordPuzzle(List<String> crossword, String wordsString) {
        List<String> words = new ArrayList<>(Arrays.asList(wordsString.split(";")));
        dfs(words, crossword, new HashSet<>());
        return solution;
    }

    private static void dfs(List<String> words, List<String> crossword, Set<String> used) {
        if (words.size() == used.size()) {
            // for some reason the first call on the recursion stack is not updating the list reference
            // I'm bypassing that with this static variable
            // TODO investigate why
            solution = crossword;
        }
        for (String word : words) {
            if (!used.contains(word)) {
                used.add(word);
                List<String> prevCrossword = new ArrayList<>(crossword);
                if (tryInsertingWord(crossword, word, true) || tryInsertingWord(crossword, word, false)) {
                    dfs(words, crossword, used);
                }
                used.remove(word);
                crossword = prevCrossword;
            }
        }
    }

    static boolean tryInsertingWord(List<String> crossword, String word, boolean checkRow) {
        for (int row = 0; row < 10; ++row) {
            for (int column = 0; column < 10; ++column) {
                boolean foundError = (checkRow ? column : row) + word.length() > 10;
                for (int substringIndex = 0; substringIndex < word.length() && !foundError; ++substringIndex) {
                    if (crossword.get(checkRow ? row : row + substringIndex).charAt(checkRow ? column + substringIndex : column) != '-'
                            && crossword.get(checkRow ? row : row + substringIndex).charAt(checkRow ? column + substringIndex : column) != word.charAt(substringIndex)) {
                        foundError = true;
                        break;
                    }
                }
                if (!foundError) {
                    for (int substringIndex = 0; substringIndex < word.length(); ++substringIndex) {
                        String s = crossword.get(checkRow ? row : row + substringIndex);
                        s = (s.substring(0, checkRow ? column + substringIndex : column) + word.charAt(substringIndex) + s.substring(checkRow ? column + substringIndex + 1 : column + 1));
                        crossword.remove(checkRow ? row : row + substringIndex);
                        crossword.add(checkRow ? row : row + substringIndex, s);
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
