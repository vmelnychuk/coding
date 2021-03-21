package io.learn.javacore.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    private Stack<Vertex> stack;
    private List<Vertex> traversalPath;

    public DepthFirstSearch() {
        this.stack = new Stack<>();
        this.traversalPath = new ArrayList<>();
    }

    public List<Vertex> dfs(List<Vertex> vertices) {
        for (Vertex vertex : vertices) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsWithRecursion(vertex);
            }
        }
        return traversalPath;
    }

    private void dfsWithStack(Vertex startNode) {
        this.stack.add(startNode);
        startNode.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex currentNode = this.stack.pop();
            this.traversalPath.add(currentNode);

            for (Vertex neighbour : currentNode.getNeighbours()) {
                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    this.stack.push(neighbour);
                }
            }
        }
    }

    private void dfsWithRecursion(Vertex startNode) {
        this.traversalPath.add(startNode);
        for (Vertex vertex : startNode.getNeighbours()) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsWithRecursion(vertex);
            }
        }
    }
}
