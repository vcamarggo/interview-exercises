package com.interview.sde.java.string;

//https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
public class RemoveAllOccurrenceSubstring {
    public String removeOccurrences(String s, String part) {
        int partIndex = s.indexOf(part);
        while(partIndex != -1){
            s = s.substring(0, partIndex) + s.substring(partIndex + part.length());
            partIndex = s.indexOf(part);
        }
        return s;
    }
}
