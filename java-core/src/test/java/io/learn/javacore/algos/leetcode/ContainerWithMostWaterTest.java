package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    private ContainerWithMostWater containerWithMostWater;

    @BeforeEach
    void setUp() {
        containerWithMostWater = new ContainerWithMostWater();
    }

    @Test
    void maxAreaEx1() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expectedResult = 49;

        int result = containerWithMostWater.maxArea(height);

        assertEquals(expectedResult, result);
    }

    @Test
    void maxAreaEx2() {
        int[] height = new int[]{1, 1};
        int expectedResult = 1;

        int result = containerWithMostWater.maxArea(height);

        assertEquals(expectedResult, result);
    }

    @Test
    void maxAreaEx3() {
        int[] height = new int[]{4, 3, 2, 1, 4};
        int expectedResult = 16;

        int result = containerWithMostWater.maxArea(height);

        assertEquals(expectedResult, result);
    }

    @Test
    void maxAreaEx4() {
        int[] height = new int[]{1, 2, 1};
        int expectedResult = 2;

        int result = containerWithMostWater.maxArea(height);

        assertEquals(expectedResult, result);
    }
}
