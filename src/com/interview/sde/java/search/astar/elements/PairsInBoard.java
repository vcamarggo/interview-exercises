package com.interview.sde.java.search.astar.elements;

public class PairsInBoard {
    private final RowColumnPair startingPoint;
    private final RowColumnPair targetPoint;

    public PairsInBoard(RowColumnPair startingPoint, RowColumnPair targetPoint) {
        this.startingPoint = startingPoint;
        this.targetPoint = targetPoint;
    }

    public RowColumnPair getStartingPoint() {
        return startingPoint;
    }

    public RowColumnPair getTargetPoint() {
        return targetPoint;
    }
}
