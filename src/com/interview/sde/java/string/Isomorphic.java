package com.interview.sde.java.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/isomorphic-strings/
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!sToT.containsKey(s.charAt(i)) && !tToS.containsKey(t.charAt(i))) {
                sToT.put(s.charAt(i), t.charAt(i));
                tToS.put(t.charAt(i), s.charAt(i));
            } else if (sToT.containsKey(s.charAt(i)) && t.charAt(i) != sToT.get(s.charAt(i))
                    || tToS.containsKey(t.charAt(i)) && s.charAt(i) != tToS.get(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Isomorphic().isIsomorphic("paper", "title");
    }
}
