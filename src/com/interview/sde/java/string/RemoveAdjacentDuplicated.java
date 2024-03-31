package com.interview.sde.java.string;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
public class RemoveAdjacentDuplicated {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                sb.delete(i - 1, i + 1); //delete bad chars
                i = Math.max(i - 2, 0); // reset index to reevaluate current position,
                                        // -2 is required because of the for +1
                                        // at the end of this iteration
            }
        }
        return sb.toString();
    }
}
