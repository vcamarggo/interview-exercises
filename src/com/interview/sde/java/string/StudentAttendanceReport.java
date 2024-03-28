package com.interview.sde.java.string;

//https://leetcode.com/problems/student-attendance-record-i/
public class StudentAttendanceReport {
    public boolean checkRecord(String s) {
        boolean lostAClassBefore = false;
        int a1 = Integer.MIN_VALUE;
        int a2 = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                // lostAClassBefore is only true here when we had already been Absent from a class before
                if (lostAClassBefore) return false;
                lostAClassBefore = true;
            }
            if (c == 'L') {
                //if previous element was L
                if (a1 + 1 == i) {
                    a2 = i;
                    //if there were two L in a row, the third one should return false
                } else if (a2 + 1 == i) {
                    return false;
                    //else, they are not in a row, and we should reset the first counter
                } else {
                    a1 = i;
                }
            }
        }
        return true;
    }
}
