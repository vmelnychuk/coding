package io.learn.javacore.graph.dijkstra;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import io.learn.javacore.graph.bfs.ConversionFactor;
import io.learn.javacore.graph.bfs.Unit;

public class DijkstraAlgorithm {
    private final int EDGE_WEIGHT = 1;
    List<ConversionFactor> conversionFactors;

    public DijkstraAlgorithm(List<ConversionFactor> conversionFactors) {
        this.conversionFactors = conversionFactors;
    }

    // todo: add graph reset
//    public List<UnitNode> getConversionFromTo(UnitNode from, UnitNode to) {
//        computePath(from);
//        List<UnitNode> shortestPathFromTo = getShortestPathTo(to);
//        UnitNode first = shortestPathFromTo.get(0);
//        first.setCalculatedFactor(first.getUnit().getFactor());
//        for (int i = 0; i < shortestPathFromTo.size() - 1; i++) {
//            UnitNode current = shortestPathFromTo.get(i);
//            UnitNode next = shortestPathFromTo.get(i + 1);
//            next.setCalculatedFactor(calculateConversionFactor(current, next));
//        }
//
//        return shortestPathFromTo;
//    }

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

    public List<UnitNode> getConversionTo(UnitNode to) {
        List<UnitNode> shortestPathTo = getShortestPathTo(to);
        UnitNode first = shortestPathTo.get(0);
        first.setCalculatedFactor(first.getUnit().getFactor());
        for (int i = 0; i < shortestPathTo.size() - 1; i++) {
            UnitNode current = shortestPathTo.get(i);
            UnitNode next = shortestPathTo.get(i + 1);
            next.setCalculatedFactor(calculateConversionFactor(current, next));
        }

        return shortestPathTo;
    }

    public List<UnitNode> getShortestPathTo(UnitNode targetNode) {
        List<UnitNode> shortestPath = new ArrayList<>();
        for (UnitNode unitNode = targetNode; unitNode != null; unitNode = unitNode.getPreviousNode()) {
            shortestPath.add(unitNode);
        }

        Collections.reverse(shortestPath);

        return shortestPath;
    }

    private BigDecimal calculateConversionFactor(UnitNode currentNode, UnitNode neighbour) {
        if (!currentNode.isBaseUnit() && neighbour.isBaseUnit()) {
            return neighbour.getUnit().getFactor().divide(currentNode.getCalculatedFactor(), MathContext.DECIMAL128);
        } else if (currentNode.isBaseUnit() && !neighbour.isBaseUnit()) {
            return neighbour.getUnit().getFactor().multiply(currentNode.getCalculatedFactor());
        } else if (currentNode.isBaseUnit() && neighbour.isBaseUnit()) {
            BigDecimal factorForUnits = getFactorForUnits(currentNode.getUnit(), neighbour.getUnit());
            return neighbour.getUnit().getFactor()
                .multiply(currentNode.getCalculatedFactor())
                .multiply(factorForUnits);
        } else {
            throw new IllegalArgumentException("Two neighbours nodes have type subunit");
        }
    }

    BigDecimal getFactorForUnits(Unit from, Unit to) {
        for (ConversionFactor conversionFactor : conversionFactors) {
            if (conversionFactor.getFrom().equals(from) && conversionFactor.getTo().equals(to)) {
                return conversionFactor.getFactor();
            } else if (conversionFactor.getFrom().equals(to) && conversionFactor.getTo().equals(from)) {
                return BigDecimal.valueOf(1).divide(conversionFactor.getFactor(), MathContext.DECIMAL128);
            }
        }
        throw new IllegalArgumentException(
            String.format("No conversion factor for conversion from %s to %s was provided", from.getName(), to.getName())
        );
    }
}
