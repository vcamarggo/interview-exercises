package com.interview.sde.java.search.astar.elements;

public record RowColumnPair(int row, int column) {

    @Override
    public String toString() {
        return "RowColumnPair{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
