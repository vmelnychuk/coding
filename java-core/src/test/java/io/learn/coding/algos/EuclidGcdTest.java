package io.learn.coding.algos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EuclidGcdTest {
    private final EuclidGcd gcd = new EuclidGcd();

    @Test
    @DisplayName("GCD of 8 and 5 is 1")
    public void gcdOf8And5() {
        int result = gcd.calculate(8, 5);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("GCD of 1 and 1 is 1")
    public void testGcdOf1And1() {
        int result = gcd.calculate(1, 1);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("GCD of 100 and 0 should be 100")
    public void testGcdOf100And0() {
        int result = gcd.calculate(100, 0);
        assertEquals(100, result);
    }

    @Test
    @DisplayName("GCD of 0 and 0 should be 0")
    public void testGcdOf0And0() {
        int result = gcd.calculate(0, 0);
        assertEquals(0, result);
    }
}
