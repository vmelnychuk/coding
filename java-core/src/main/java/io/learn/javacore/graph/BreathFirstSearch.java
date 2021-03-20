package io.learn.javacore.graph;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreathFirstSearch {
    private Map<String, BigDecimal> conversionTable = new HashMap<>();

    public void traverse(UnitNode startNode) {
        Queue<UnitNode> queue = new LinkedList<>();

        startNode.setVisited(true);
        queue.add(startNode);

        while(!queue.isEmpty()) {
            UnitNode currentNode = queue.remove();
            System.out.println("Current visited node: " + currentNode);
            for (UnitNode neighbour : currentNode.getAdjacencyList()) {
                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    queue.add(neighbour);
                    // calculate conversion
                    if (currentNode.isBaseUnit() && !neighbour.isBaseUnit()) {
                        String key = startNode.getUnit().getName() + "-" + neighbour.getUnit().getName();
                        BigDecimal conversionFactor = currentNode.getUnit().getFactor().multiply(neighbour.getUnit().getFactor());
                        conversionTable.put(key, conversionFactor);
                    } else if (!startNode.isBaseUnit() && neighbour.isBaseUnit()) {
                        String key = startNode.getUnit().getName() + "-" + neighbour.getUnit().getName();
                        BigDecimal conversionFactor = currentNode.getUnit().getFactor().divide(neighbour.getUnit().getFactor());
                        conversionTable.put(key, conversionFactor);
                    } else if (currentNode.isBaseUnit() && neighbour.isBaseUnit()) {
                        throw new UnsupportedOperationException("Two base units is not supported yet.");
                        //todo: add lookup table
//                        String key = currentNode.getUnit().getName() + "-" + neighbour.getUnit().getName();
//                        BigDecimal conversionFactor = neighbour.getUnit().getFactor().multiply(currentNode.getUnit().getFactor());
//                        conversionTable.put(key, conversionFactor);
                    }
                }
            }
        }
    }

    public Map<String, BigDecimal> getConversionTable() {
        return conversionTable;
    }
}
