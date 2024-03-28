package com.interview.sde.java.string;

import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
public class ReverseVowels {
    public String reverseVowels(String s) {

        //Over allocating memory, probably can be done with fewer objects.
        //Idea: Concatenating the array at the end of the sb and then replacing/removing them on the next loop
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> vowelsOrder = new Stack<>();
        Set<Character> vowels = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

        for (int i = 0; i < s.length(); i++) {
            char charAtI = s.charAt(i);
            if (vowels.contains(charAtI)) {
                vowelsOrder.push(charAtI);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char charAtI = s.charAt(i);
            if (vowels.contains(charAtI)) {
                sb.replace(i, i + 1, String.valueOf(vowelsOrder.pop()));
            }
        }
        return sb.toString();
    }
}
