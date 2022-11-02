package com.interview.sde.oop.monitoring;

import java.util.*;

public class DashboardProvider {
    //TreeMap to order timestamp and allow querying by timestamp
    //If insertion timestamp is monotonically increasing, LinkedHashMap can also be used, but that is hard to guarantee in a wall-clock
    private static TreeMap<Long, DataPoint> dataset = new TreeMap<>();

    public static void main(String[] args) {
        Random randomGenerator = new Random();

        receiveData(System.currentTimeMillis(), List.of(randomGenerator.nextDouble()));

        long t2 = System.currentTimeMillis();

        receiveData(t2,
                List.of(randomGenerator.nextDouble(),
                        randomGenerator.nextDouble(),
                        randomGenerator.nextDouble(),
                        randomGenerator.nextDouble()));

        printStatistics(t2);

    }

    static void receiveData(Long timestamp, List<Double> data) {
        dataset.compute(timestamp, (key, dataPoint) -> {
            if (dataPoint == null) {
                dataPoint = new DataPoint();
            }
            dataPoint.insertData(data);
            return dataPoint;
        });
    }

    static void printStatistics(Long timestamp) {
        dataset.computeIfPresent(timestamp, (aLong, dataPoint) -> {
            dataPoint.printMin();
            dataPoint.printMax();
            dataPoint.printAverage();
            return dataPoint;
        });
    }

}
