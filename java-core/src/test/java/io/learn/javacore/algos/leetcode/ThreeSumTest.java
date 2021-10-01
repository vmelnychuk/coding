package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThreeSumTest {

    private ThreeSum threeSum;

    @BeforeEach
    void setUp() {
        threeSum = new ThreeSum();
    }

    @Test
    void threeSumEx1() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expectedResult = List.of(
            List.of(-1, -1, 2),
            List.of(-1, 0, 1)
        );

        List<List<Integer>> result = threeSum.threeSum(nums);

        assertTrue(expectedResult.size() == result.size() && expectedResult.containsAll(result) && result.containsAll(expectedResult));
    }

    @Test
    void threeSumEx2() {
        int[] nums = {};
        List<List<Integer>> expectedResult = List.of();

        List<List<Integer>> result = threeSum.threeSum(nums);

        assertTrue(expectedResult.size() == result.size() && expectedResult.containsAll(result) && result.containsAll(expectedResult));
    }

    @Test
    void threeSumEx3() {
        int[] nums = new int[]{0};
        List<List<Integer>> expectedResult = List.of();

        List<List<Integer>> result = threeSum.threeSum(nums);

        assertTrue(expectedResult.size() == result.size() && expectedResult.containsAll(result) && result.containsAll(expectedResult));
    }
}
