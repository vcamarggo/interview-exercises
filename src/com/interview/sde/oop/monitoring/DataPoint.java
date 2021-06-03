package com.interview.sde.oop.monitoring;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class DataPoint {
    private List<Double> data;
    private BigDecimal sumForAverage;
    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;

    public DataPoint() {
        this.data = new LinkedList<>();
        this.sumForAverage = new BigDecimal(0);
    }

    public void insertData(Double data) {
        insertData(List.of(data));
    }

    public void insertData(List<Double> dataList) {
        for (Double d : dataList) {
            this.min = Math.min(min, d);
            this.max = Math.max(max, d);
            sumForAverage = sumForAverage.add(new BigDecimal(d));
            data.add(d);
        }
    }

    public void printMin() {
        System.out.println("Min: " + min);
    }

    public void printMax() {
        System.out.println("Max: " + max);
    }

    public void printAverage() {
        System.out.println("Avg: " + sumForAverage.divide(new BigDecimal(data.size()), RoundingMode.UNNECESSARY));
    }
}
