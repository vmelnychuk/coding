package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    void twoSumEx1() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = new int[]{0, 1};

        int[] result = twoSum.twoSum(nums, target);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    void twoSumEx2() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] expectedResult = new int[]{1, 2};

        int[] result = twoSum.twoSum(nums, target);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    void twoSumEx3() {
        int[] nums = new int[]{3, 3};
        int target = 6;
        int[] expectedResult = new int[]{0, 1};

        int[] result = twoSum.twoSum(nums, target);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    void twoSumOpEx1() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = new int[]{0, 1};

        int[] result = twoSum.twoSumOptimized(nums, target);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    void twoSumOpEx2() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] expectedResult = new int[]{1, 2};

        int[] result = twoSum.twoSumOptimized(nums, target);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    void twoSumOpEx3() {
        int[] nums = new int[]{3, 3};
        int target = 6;
        int[] expectedResult = new int[]{0, 1};

        int[] result = twoSum.twoSumOptimized(nums, target);

        assertArrayEquals(expectedResult, result);
    }
}
