package com.interview.sde.algorithm.datastructure;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-underground-system/
public class UndergroundSystem {

    static class TripStatistics {
        int numberTrips = 0;
        int time = 0;

        public void updateStatistics(int timeToTravel) {
            this.numberTrips += 1;
            this.time += timeToTravel;
        }
    }

    static class Checkpoint {
        String stationName;
        int time;

        Checkpoint(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    Map<String, TripStatistics> averageTimeCheckpoints;
    Map<Integer, Checkpoint> travelsInProgress;

    public UndergroundSystem() {
        averageTimeCheckpoints = new HashMap<>();
        travelsInProgress = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        travelsInProgress.put(id, new Checkpoint(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Checkpoint checkpoint = travelsInProgress.get(id);
        int timeToTravel = t - checkpoint.time;
        String key = generateKey(checkpoint.stationName, stationName);

        TripStatistics statistics = averageTimeCheckpoints.getOrDefault(key, new TripStatistics());

        statistics.updateStatistics(timeToTravel);

        averageTimeCheckpoints.put(key, statistics);
    }

    private String generateKey(String startStation, String endStation) {
        return startStation + "#" + endStation;
    }

    public double getAverageTime(String startStation, String endStation) {
        TripStatistics statistics = averageTimeCheckpoints.get(generateKey(startStation, endStation));
        return statistics.time / (double) statistics.numberTrips;

    }
}
