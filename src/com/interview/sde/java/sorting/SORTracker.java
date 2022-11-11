package com.interview.sde.java.sorting;

import java.util.TreeSet;

//https://leetcode.com/problems/sequentially-ordinal-rank-tracker/
public class SORTracker {
    private final TreeSet<Location> dataStore = new TreeSet<>();
    private Location currentLocation = new Location("", Integer.MAX_VALUE);

    public void add(String name, int score) {
        Location newLocation = new Location(name, -score);
        dataStore.add(newLocation);
        // every time that a new location smaller than the last retrieved location is added,
        // it must go back one location in the "iterator"
        if (newLocation.compareTo(currentLocation) < 0) {
            currentLocation = dataStore.lower(currentLocation);
        }
    }

    public String get() {
        // Fetch next element to return
        currentLocation = dataStore.higher(currentLocation);
        return currentLocation.name;
    }

    static class Location implements Comparable<Location> {
        final String name;
        private final Integer score;

        public Location(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Location o) {
            int diff = Integer.compare(this.score, o.score);
            if (diff == 0) {
                return this.name.compareTo(o.name);
            }
            return diff;
        }
    }
}
