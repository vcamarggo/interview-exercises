package com.interview.sde.algorithm.datastructure;

import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/
public class MyCalendarI {

    TreeMap<Integer, Integer> bookings;


    public MyCalendarI() {
        bookings = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer k = bookings.ceilingKey(start);

        // there was an element starting at the same time or ending during the one we want to add
        if (k != null && (k == start || k < end)) {
            return false;
        }

        k = bookings.lowerKey(start);
        // the event we want to add starts during another event
        if (k != null && bookings.get(k) >= start) {
            return false;
        }

        bookings.put(start, end - 1);
        return true;
    }
}
