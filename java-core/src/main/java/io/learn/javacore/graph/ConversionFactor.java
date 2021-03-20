package io.learn.javacore.graph;

import java.math.BigDecimal;

public class ConversionFactor {
    private final Unit from;
    private final Unit to;
    private final BigDecimal factor;

    public ConversionFactor(Unit from, Unit to, BigDecimal factor) {
        this.from = from;
        this.to = to;
        this.factor = factor;
    }

    public Unit getFrom() {
        return from;
    }

    public Unit getTo() {
        return to;
    }

    public BigDecimal getFactor() {
        return factor;
    }
}
