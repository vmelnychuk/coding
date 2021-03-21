package io.learn.javacore.graph.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    private final int EDGE_WEIGHT = 1;

    public List<UnitNode> getConversionFromTo(UnitNode from, UnitNode to) {
        computePath(from);
        return getShortestPathTo(to);
    }

    public void computePath(UnitNode startNode) {
        startNode.setDistance(0);
        PriorityQueue<UnitNode> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(startNode);

        while (!priorityQueue.isEmpty()) {
            UnitNode currentNode = priorityQueue.poll();
            for (UnitNode neighbour : currentNode.getNeighbours()) {
                int newDistance = currentNode.getDistance() + EDGE_WEIGHT;

                if (newDistance < neighbour.getDistance()) {
                    priorityQueue.remove(neighbour);
                    neighbour.setDistance(newDistance);
                    neighbour.setPreviousNode(currentNode);
                    priorityQueue.add(neighbour);
                }
            }
        }
    }

    public List<UnitNode> getShortestPathTo(UnitNode targetNode) {
        List<UnitNode> shortestPath = new ArrayList<>();
        for (UnitNode unitNode = targetNode; unitNode != null; unitNode = unitNode.getPreviousNode()) {
            shortestPath.add(unitNode);
        }

        Collections.reverse(shortestPath);

        return shortestPath;
    }
}
