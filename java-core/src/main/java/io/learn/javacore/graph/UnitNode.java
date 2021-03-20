package io.learn.javacore.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnitNode {
    private final Unit unit;
    private boolean visited;
    private List<UnitNode> adjacencyList;
    private final boolean baseUnit;

    public UnitNode(Unit unit, boolean baseUnit) {
        this.unit = unit;
        this.visited = false;
        this.adjacencyList = new ArrayList<>();
        this.baseUnit = baseUnit;
    }

    public UnitNode(Unit unit) {
        this.unit = unit;
        this.visited = false;
        this.adjacencyList = new ArrayList<>();
        this.baseUnit = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<UnitNode> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbor(UnitNode unitNode) {
        this.adjacencyList.add(unitNode);
    }

    public Unit getUnit() {
        return unit;
    }

    public boolean isBaseUnit() {
        return baseUnit;
    }

    @Override
    public String toString() {
        String adjacencyListRepresentation = adjacencyList.stream()
            .map(node -> node.getUnit().toString() + " visited=" + this.visited)
            .collect(Collectors.joining("|", "|", "|"));
        return "UnitNode{" +
            "unit=" + unit +
            ", visited=" + visited +
            ", adjacencyList=" + adjacencyListRepresentation +
            '}';
    }
}
