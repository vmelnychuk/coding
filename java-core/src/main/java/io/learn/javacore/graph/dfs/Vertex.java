package io.learn.javacore.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;

    private boolean visited;

    private List<Vertex> neighbours;

    public Vertex(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
        this.visited = false;
    }

    public void addNeighbor(Vertex neighbour) {
        this.neighbours.add(neighbour);
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    @Override
    public String toString() {
        return "Vertex{" +
            "name='" + name + '\'' +
            '}';
    }
}
