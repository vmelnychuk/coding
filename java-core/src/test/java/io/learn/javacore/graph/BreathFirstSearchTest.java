package io.learn.javacore.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BreathFirstSearchTest {
    @BeforeEach
    public void setup() {

    }

    @Test
    public void testGetFactorInOrder() {
        Unit toneUnit = new Unit("Tonne", BigDecimal.valueOf(1));
        Unit barrelUnit = new Unit("Barrels", BigDecimal.valueOf(1));
        Unit mmbtuUnit = new Unit("MMBTUs", BigDecimal.valueOf(1));

        List<ConversionFactor> conversionFactors = new ArrayList<>();
        conversionFactors.add(new ConversionFactor(toneUnit, barrelUnit, BigDecimal.valueOf(7.33)));
        conversionFactors.add(new ConversionFactor(barrelUnit, mmbtuUnit, BigDecimal.valueOf(5.8)));
        BreathFirstSearch breathFirstSearch = new BreathFirstSearch(conversionFactors);

        BigDecimal tonneToBarrel = breathFirstSearch.getFactorForUnits(toneUnit, barrelUnit);
        BigDecimal barrelToMmbtu = breathFirstSearch.getFactorForUnits(barrelUnit, mmbtuUnit);

        assertEquals(BigDecimal.valueOf(7.33), tonneToBarrel);
        assertEquals(BigDecimal.valueOf(5.8), barrelToMmbtu);
    }

    @Test
    public void testGetFactorNotInOrder() {
        Unit toneUnit = new Unit("Tonne", BigDecimal.valueOf(1));
        Unit barrelUnit = new Unit("Barrels", BigDecimal.valueOf(1));
        Unit mmbtuUnit = new Unit("MMBTUs", BigDecimal.valueOf(1));

        List<ConversionFactor> conversionFactors = new ArrayList<>();
        conversionFactors.add(new ConversionFactor(toneUnit, barrelUnit, BigDecimal.valueOf(7.33)));
        conversionFactors.add(new ConversionFactor(barrelUnit, mmbtuUnit, BigDecimal.valueOf(5.8)));

        BreathFirstSearch breathFirstSearch = new BreathFirstSearch(conversionFactors);

        BigDecimal barrelToBarrel = breathFirstSearch.getFactorForUnits(barrelUnit, toneUnit);

        assertEquals(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(7.33), MathContext.DECIMAL128), barrelToBarrel);
    }
}
