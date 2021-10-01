package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NonNegativeIntegersWithoutConsecutiveOnesTest {
    private NonNegativeIntegersWithoutConsecutiveOnes solver = new NonNegativeIntegersWithoutConsecutiveOnes();

    @Test
    void findIntegersEx1() {
        int num = 5;
        int expectedResult = 5;

        int result = solver.findIntegers(num);

        assertEquals(expectedResult, result);
    }

    @Test
    void findIntegersEx2() {
        int num = 1;
        int expectedResult = 2;

        int result = solver.findIntegers(num);

        assertEquals(expectedResult, result);
    }

    @Test
    void findIntegersEx3() {
        int num = 2;
        int expectedResult = 3;

        int result = solver.findIntegers(num);

        assertEquals(expectedResult, result);
    }
}
