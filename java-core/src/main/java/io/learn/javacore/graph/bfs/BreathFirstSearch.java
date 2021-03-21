package io.learn.javacore.graph.bfs;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstSearch {

    private List<UnitNode> traversalPath = new ArrayList<>();

    private final List<ConversionFactor> conversionFactors;

    public BreathFirstSearch(List<ConversionFactor> conversionFactors) {
        this.conversionFactors = conversionFactors;
    }

    public List<UnitNode> traverse(UnitNode startNode) {
        Queue<UnitNode> queue = new LinkedList<>();
        startNode.setVisited(true);
        startNode.setCalculatedFactor(startNode.getUnit().getFactor());
        queue.add(startNode);
        while (!queue.isEmpty()) {
            UnitNode currentNode = queue.remove();
            traversalPath.add(currentNode);
            for (UnitNode neighbourNode : currentNode.getAdjacencyList()) {
                if (!neighbourNode.isVisited()) {
                    neighbourNode.setVisited(true);
                    queue.add(neighbourNode);
                    neighbourNode.setCalculatedFactor(calculateConversionFactor(currentNode, neighbourNode));
                }
            }
        }
        if (traversalPath.contains(startNode)) {
            traversalPath.remove(startNode);
        }
        return traversalPath;
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
