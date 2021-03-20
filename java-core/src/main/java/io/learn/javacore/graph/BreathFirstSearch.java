package io.learn.javacore.graph;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreathFirstSearch {
    private Map<String, BigDecimal> conversionTable = new HashMap<>();
    private List<UnitNode> traversalPath = new ArrayList<>();

    public void traverse(UnitNode startNode) {
        Queue<UnitNode> queue = new LinkedList<>();

        startNode.setVisited(true);
        startNode.setCalculatedFactor(startNode.getUnit().getFactor());
        queue.add(startNode);

        while(!queue.isEmpty()) {
            UnitNode currentNode = queue.remove();
            traversalPath.add(currentNode);
            System.out.println("Current visited node: " + currentNode);
            for (UnitNode neighbour : currentNode.getAdjacencyList()) {
                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    queue.add(neighbour);
                    // calculate conversion
                    if (!currentNode.isBaseUnit() && neighbour.isBaseUnit()) {
                        neighbour.setCalculatedFactor(neighbour.getUnit().getFactor().divide(currentNode.getCalculatedFactor(), MathContext.DECIMAL128));
                        String key = startNode.getUnit().getName() + "-" + neighbour.getUnit().getName();
                        BigDecimal conversionFactor = neighbour.getCalculatedFactor();
                        conversionTable.put(key, conversionFactor);
                    } else if (currentNode.isBaseUnit() && !neighbour.isBaseUnit()) {
                        neighbour.setCalculatedFactor(neighbour.getUnit().getFactor().multiply(currentNode.getCalculatedFactor()));
                        String key = startNode.getUnit().getName() + "-" + neighbour.getUnit().getName();
                        BigDecimal conversionFactor = neighbour.getCalculatedFactor();
                        conversionTable.put(key, conversionFactor);
                    } else if (currentNode.isBaseUnit() && neighbour.isBaseUnit()) {
                        throw new UnsupportedOperationException("Two base units is not supported yet.");
                        //todo: add lookup table
//                        String key = currentNode.getUnit().getName() + "-" + neighbour.getUnit().getName();
//                        BigDecimal conversionFactor = neighbour.getUnit().getFactor().multiply(currentNode.getUnit().getFactor());
//                        conversionTable.put(key, conversionFactor);
                    } else {
                        throw new UnsupportedOperationException("How did I get here?");
                    }
                }
            }
        }
    }

    public Map<String, BigDecimal> getConversionTable() {
        return conversionTable;
    }

    public List<UnitNode> getTraversalPath() {
        return traversalPath;
    }
}
