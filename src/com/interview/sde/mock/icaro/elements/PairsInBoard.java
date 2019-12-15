package com.interview.sde.mock.icaro.elements;

import com.interview.sde.mock.icaro.elements.RowColumnPair;

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
