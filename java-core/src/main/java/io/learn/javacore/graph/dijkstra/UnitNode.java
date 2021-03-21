package io.learn.javacore.graph.dijkstra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.learn.javacore.graph.bfs.Unit;

public class UnitNode implements Comparable<UnitNode> {
    private Unit unit;
    private List<UnitNode> neighbours;
    private boolean visited;
    private UnitNode previousNode;
    private int distance = Integer.MAX_VALUE;
    private boolean baseUnit;
    private BigDecimal calculatedFactor;

    public UnitNode(Unit unit) {
        this.unit = unit;
        this.neighbours = new ArrayList<>();
        this.baseUnit = false;

    }

    public UnitNode(Unit unit, boolean baseUnit) {
        this.unit = unit;
        this.neighbours = new ArrayList<>();
        this.baseUnit = baseUnit;
    }

    public void addNeighbor(UnitNode neighbor) {
        this.neighbours.add(neighbor);
    }

    public List<UnitNode> getNeighbours() {
        return neighbours;
    }

    public UnitNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(UnitNode previousNode) {
        this.previousNode = previousNode;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(boolean baseUnit) {
        this.baseUnit = baseUnit;
    }

    @Override
    public int compareTo(UnitNode other) {
        return Integer.compare(this.distance, other.getDistance());
    }

    @Override
    public String toString() {
        return "UnitNode{" +
            "unit=" + unit +
            ", calculatedFactor=" + calculatedFactor +
            '}';
    }

    public BigDecimal getCalculatedFactor() {
        return calculatedFactor;
    }

    public void setCalculatedFactor(BigDecimal calculatedFactor) {
        this.calculatedFactor = calculatedFactor;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
