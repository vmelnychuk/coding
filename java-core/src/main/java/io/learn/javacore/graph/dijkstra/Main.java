package io.learn.javacore.graph.dijkstra;

import java.math.BigDecimal;
import java.util.List;

import io.learn.javacore.graph.bfs.Unit;

public class Main {

    public static void main(String[] args) {
        // Weight
        Unit tonneUnit = new Unit("Tonne", BigDecimal.valueOf(1));
        UnitNode tonne = new UnitNode(tonneUnit, true);
        UnitNode pound = new UnitNode(new Unit("Pounds", BigDecimal.valueOf(2204.624023)));
        UnitNode troyOunce = new UnitNode(new Unit("Troy Ounces", BigDecimal.valueOf(32150.75)));
        UnitNode kiloTonne = new UnitNode(new Unit("Kilo Tonnes", BigDecimal.valueOf(0.001)));
        UnitNode gram = new UnitNode(new Unit("Grams", BigDecimal.valueOf(1000000)));
        UnitNode tael = new UnitNode(new Unit("Taels", BigDecimal.valueOf(26666.669922)));

        tonne.addNeighbor(pound);
        tonne.addNeighbor(troyOunce);
        tonne.addNeighbor(kiloTonne);
        tonne.addNeighbor(gram);
        tonne.addNeighbor(tael);

        pound.addNeighbor(tonne);
        troyOunce.addNeighbor(tonne);
        kiloTonne.addNeighbor(tonne);
        gram.addNeighbor(tonne);
        tael.addNeighbor(tonne);

        // Volume
        Unit barrelUnit = new Unit("Barrels", BigDecimal.valueOf(1));
        UnitNode barrel = new UnitNode(barrelUnit, true);
        UnitNode usGallons = new UnitNode(new Unit("US Gallons", BigDecimal.valueOf(42)));
        UnitNode litres = new UnitNode(new Unit("Litres", BigDecimal.valueOf(158.988403)));
        UnitNode cubicMetres = new UnitNode(new Unit("Cubic Metres", BigDecimal.valueOf(0.158987)));

        barrel.addNeighbor(usGallons);
        barrel.addNeighbor(litres);
        barrel.addNeighbor(cubicMetres);

        usGallons.addNeighbor(barrel);
        litres.addNeighbor(barrel);
        cubicMetres.addNeighbor(barrel);

        // Energy
        Unit mmbtuUnit = new Unit("MMBTUs", BigDecimal.valueOf(1));
        UnitNode mmbtu = new UnitNode(mmbtuUnit, true);
        UnitNode gigaJoules = new UnitNode(new Unit("Giga Joules", BigDecimal.valueOf(1.055056)));
        UnitNode kilowattHours = new UnitNode(new Unit("Kilowatt Hours", BigDecimal.valueOf(293.071014)));
        UnitNode decaTherms = new UnitNode(new Unit("Deca Therms", BigDecimal.valueOf(1)));

        mmbtu.addNeighbor(gigaJoules);
        mmbtu.addNeighbor(kilowattHours);
        mmbtu.addNeighbor(decaTherms);

        gigaJoules.addNeighbor(mmbtu);
        kilowattHours.addNeighbor(mmbtu);
        decaTherms.addNeighbor(mmbtu);

        // between graphs
        tonne.addNeighbor(barrel);
        barrel.addNeighbor(tonne);
        barrel.addNeighbor(mmbtu);
        mmbtu.addNeighbor(barrel);

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        //dijkstra.computePath(pound);
        //List<UnitNode> shortestPathToKilowattHours = dijkstra.getShortestPathTo(kilowattHours);
        //System.out.println("\tpath to:\n" + shortestPathToKilowattHours);

        System.out.println("\tdijkstra.getConversionFromTo(tonne, mmbtu) \n" + dijkstra.getConversionFromTo(tonne, mmbtu));
    }
}
