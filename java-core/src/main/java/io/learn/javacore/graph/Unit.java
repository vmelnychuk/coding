package io.learn.javacore.graph;

import java.math.BigDecimal;

public class Unit {
    private final String name;
    private final BigDecimal factor;

    public Unit(String name, BigDecimal factor) {
        this.name = name;
        this.factor = factor;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    @Override
    public String toString() {
        return "Unit{" +
            "name='" + name + '\'' +
            ", factor=" + factor +
            '}';
    }
}
