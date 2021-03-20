package io.learn.javacore.graph;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        UnitNode tonne = new UnitNode(new Unit("Tonne", BigDecimal.valueOf(1)), true);
        UnitNode pound = new UnitNode(new Unit("Pounds", BigDecimal.valueOf(2204.624023)));
        UnitNode troyOunce = new UnitNode(new Unit("Troy Ounces", BigDecimal.valueOf(32150.75)));
        UnitNode kiloTonne = new UnitNode(new Unit("Kilo Tonnes", BigDecimal.valueOf(0.001)));

        tonne.addNeighbor(pound);
        tonne.addNeighbor(troyOunce);
        tonne.addNeighbor(kiloTonne);

        pound.addNeighbor(tonne);
        troyOunce.addNeighbor(tonne);
        kiloTonne.addNeighbor(tonne);

        BreathFirstSearch breathFirstSearch = new BreathFirstSearch();
        breathFirstSearch.traverse(tonne);

        Map<String, BigDecimal> conversionTable = breathFirstSearch.getConversionTable();
        String tableString = conversionTable.keySet().stream()
            .map(key -> key + "=" + conversionTable.get(key))
            .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(tableString);

        List<UnitNode> traversalPath = breathFirstSearch.getTraversalPath();
        System.out.println("\tTraversal Path:");
        for(UnitNode unitNode : traversalPath) {
            System.out.println(unitNode);
        }
    }
}
