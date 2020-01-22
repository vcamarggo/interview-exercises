package com.interview.sde.mock.icaro.astar.elements;

import java.util.Objects;

public class RowColumnPair {
    private final int row;
    private final int column;

    public RowColumnPair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowColumnPair rowColumnPair = (RowColumnPair) o;
        return row == rowColumnPair.row &&
                column == rowColumnPair.column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "RowColumnPair{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
