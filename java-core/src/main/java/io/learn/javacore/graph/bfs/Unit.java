package io.learn.javacore.graph.bfs;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(getName(), unit.getName()) && Objects.equals(getFactor(), unit.getFactor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFactor());
    }
}
