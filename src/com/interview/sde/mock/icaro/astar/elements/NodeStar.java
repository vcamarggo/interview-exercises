package com.interview.sde.mock.icaro.astar.elements;

public class NodeStar extends Node implements Comparable<NodeStar> {

    private int fScore;
    private int gScore;

    public NodeStar(char elem, int depth, int row, int column) {
        super(elem, depth, row, column);
    }

    public NodeStar(char elem, int gScore, int row, int column, int fScore) {
        super(elem, gScore, row, column);
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
                ", elem=" + elem +
                ", point=" + point +
                '}';
    }
}
