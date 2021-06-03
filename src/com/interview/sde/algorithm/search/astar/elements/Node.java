package com.interview.sde.algorithm.search.astar.elements;

import java.util.Objects;

public class Node {
    protected int depth;
    protected char elem;
    protected RowColumnPair point;

    public Node(char elem, int depth, int row, int column) {
        this.depth = depth;
        this.elem = elem;
        this.point = new RowColumnPair(row, column);
    }

    public int getDepth() {
        return depth;
    }

    public char getElem() {
        return elem;
    }

    public RowColumnPair getPoint() {
        return point;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(point, node.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    @Override
    public String toString() {
        return "Node{" +
                "depth=" + depth +
                ", elem=" + elem +
                ", rowColumnPair=" + point +
                '}';
    }
}
