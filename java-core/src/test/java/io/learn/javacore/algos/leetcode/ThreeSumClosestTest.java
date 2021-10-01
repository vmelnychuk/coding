package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ThreeSumClosestTest {

    ThreeSumClosest threeSumClosest = new ThreeSumClosest();

    @Test
    void threeSumClosest() {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        int expectedResult = 2;

        int result = threeSumClosest.threeSumClosest(nums, target);
        assertEquals(expectedResult, result);
    }
}
