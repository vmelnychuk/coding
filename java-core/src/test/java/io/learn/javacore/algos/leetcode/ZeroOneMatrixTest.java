package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ZeroOneMatrixTest {

    private ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();

    @Test
    void updateMatrixEx1() {
        int[][] input = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int[][] expectedResult = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int[][] result = zeroOneMatrix.updateMatrix(input);

        assertTrue(Arrays.deepEquals(expectedResult, result));
    }

    @Test
    void updateMatrixEx2() {
        int[][] input = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] expectedResult = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {1, 2, 1}
        };

        int[][] result = zeroOneMatrix.updateMatrix(input);

        assertTrue(Arrays.deepEquals(expectedResult, result));
    }
}
