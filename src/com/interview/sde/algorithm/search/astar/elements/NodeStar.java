package com.interview.sde.algorithm.search.astar.elements;

public class NodeStar extends Node implements Comparable<NodeStar> {

    private int fScore;
    private int gScore;

    public NodeStar(int depth, int row, int column) {
        super(depth, row, column);
    }

    public NodeStar(int gScore, int row, int column, int fScore) {
        super(gScore, row, column);
        this.fScore = fScore;
    }

    public int getFScore() {
        return fScore;
    }

    public void setFScore(int fScore) {
        this.fScore = fScore;
    }

    public int getGScore() {
        return gScore;
    }

    public void setGScore(int gScore) {
        this.gScore = gScore;
    }

    @Override
    public int compareTo(NodeStar o) {
        if (this.point.equals(o.point)) {
            return 0;
        }
        if (this.fScore == o.fScore) {
            return -1;
        }
        return (this.fScore - o.fScore);
    }

    @Override
    public String toString() {
        return "NodeStar{" +
                "fScore=" + fScore +
                ", gScore=" + gScore +
                ", depth=" + depth +
                ", point=" + point +
                '}';
    }
}
