package com.interview.sde.oop.monitoring;

import java.util.*;

public class DashboardProvider {
    private static HashMap<Long, DataPoint> dataset = new HashMap<>();

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
        DataPoint d1 = new DataPoint();
        dataset.putIfAbsent(timestamp, d1);
        dataset.computeIfPresent(timestamp, (aLong, dataPoint) -> {
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
