package io.learn.javacore.graph.dijkstra;

public class Edge {
    private int weight;
    private UnitNode starting;
    private UnitNode target;

    public Edge(int weight, UnitNode starting, UnitNode target) {
        this.weight = weight;
        this.starting = starting;
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public UnitNode getStarting() {
        return starting;
    }

    public void setStarting(UnitNode starting) {
        this.starting = starting;
    }

    public UnitNode getTarget() {
        return target;
    }

    public void setTarget(UnitNode target) {
        this.target = target;
    }
}
